package com.company.goodville.rest.Implementation;

import Persistor.LogRequests;
import Response.VehicleInformation;
import Response.VehicleInformationList;
import Response.VinNumberResult;
import Validator.VinValidator;
import com.company.goodville.rest.Service.VehicleInformationService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class VehicleInformationImpl implements VehicleInformationService {

    VehicleInformation vehicleInformation = new VehicleInformation();

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleInformationImpl.class);

    @Cacheable("vehicleInformation")
    public VehicleInformation getVehicleInformation(String vinNumber, CheckCache checkCache) {
        LOGGER.info("getVehicleInformation called for VIN Number", vinNumber);

//        LOGGER.info("VIN is ordered from NHTSA an is added to the cache");

        checkCache.setCheckCache(true);

        VinValidator vinValidator = new VinValidator();

         if(!vinValidator.isVinValid(vinNumber)) {

             return vehicleInformation;
         }

        final String uri = "https://vpic.nhtsa.dot.gov/api/vehicles/decodevin/" + vinNumber + "?format=json";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
        ObjectMapper mapper = new ObjectMapper();

        try {

            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            TypeReference<VehicleInformationList> vinNumberResult = new TypeReference<VehicleInformationList>() {};
            VehicleInformationList Result = mapper.readValue(result, vinNumberResult);

            vehicleInformation = new VehicleInformation();
            List<VinNumberResult> vinNumberResultList = Result.getResults();

           for(VinNumberResult vinInfo : vinNumberResultList){
               if(vinInfo.getVariable().equalsIgnoreCase("Make")){
                   vehicleInformation.setMake(vinInfo.getValue());
               }
               if(vinInfo.getVariable().equalsIgnoreCase("Model")){
                   vehicleInformation.setModel(vinInfo.getValue());
               }
               if(vinInfo.getVariable().equalsIgnoreCase("Model Year")){
                   vehicleInformation.setYear(vinInfo.getValue());
               }
           }
            LogRequests logRequests = new LogRequests();
            logRequests.logRequests(vehicleInformation, vinNumber);

            System.out.println(Result);

            System.out.println("Results " + Result);
            System.out.println("We have data!");

            } catch (JsonMappingException jsonMappingException) {
            jsonMappingException.printStackTrace();
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
        }

        return vehicleInformation;
    }

    @Cacheable("vehicleInformation")
    public VehicleInformation updateVehicleInformation(String vinNumber, VehicleInformation vehicleInformation) {

        LOGGER.info("getVehicleInformation called for VIN Number", vinNumber);

        LOGGER.info("VIN is order from NHTSA an is added to the cache");

        LOGGER.info("Vehicle Year: " + vehicleInformation.getYear());
        LOGGER.info("Vehicle Make: " + vehicleInformation.getMake());
        LOGGER.info("Vehicle Model: " + vehicleInformation.getModel());
        return vehicleInformation;
    }
}
