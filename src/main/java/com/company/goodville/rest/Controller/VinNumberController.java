package com.company.goodville.rest.Controller;
import Errors.ErrorCodes;
import Response.VehicleInformation;

import com.company.goodville.rest.Implementation.CheckCache;
import com.company.goodville.rest.Service.VehicleInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.Map;

@RestController
@ComponentScan(basePackages= {"com.company.goodville.rest"})
@Produces("application/json")
public class VinNumberController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VinNumberController.class);

    @Autowired
    VehicleInformationService vehicleInformationService;

    CheckCache checkCache = new CheckCache();

    @CrossOrigin("http://localhost:8084")
    @RequestMapping("/lookup")
    @ResponseBody
    @Produces("application/json")
    public ResponseEntity getVehicleInformation(@RequestParam("vinNumber") String vinNumber, Map<String, Object> model) {

        LOGGER.info("getVehicleInformation called for VIN Number", vinNumber);

        System.out.println("We're in the Controller Room");

        VehicleInformation vehicleInformationResponse;

        vehicleInformationResponse = vehicleInformationService.getVehicleInformation(vinNumber, checkCache);

        if(checkCache.isCheckCache() == true){
            LOGGER.info("VIN is ordered from NHTSA an is added to the cache");
        }else{
            LOGGER.info("VIN is NOT ordered from NHTSA a 2nd time");
        }
        checkCache.setCheckCache(false);


        if(vehicleInformationResponse.getYear() == null && vehicleInformationResponse.getMake() == null && vehicleInformationResponse.getModel() == null){

            ErrorCodes errorCodes = new ErrorCodes();
            errorCodes.setInvalidVinNumber(ErrorCodes.INVALID_VIN_NUMBER);

            LOGGER.info("Vehicle Year: " + vehicleInformationResponse.getYear());
            LOGGER.info("Vehicle Make: " + vehicleInformationResponse.getMake());
            LOGGER.info("Vehicle Model: " + vehicleInformationResponse.getModel());

            return new ResponseEntity<>(errorCodes, HttpStatus.BAD_REQUEST);
        }

        LOGGER.info("Vehicle Year: " + vehicleInformationResponse.getYear());
        LOGGER.info("Vehicle Make: " + vehicleInformationResponse.getMake());
        LOGGER.info("Vehicle Model: " + vehicleInformationResponse.getModel());
        if(LOGGER.isTraceEnabled()) {
            LOGGER.trace("VIN is NOT ordered from NHTSA a 2nd time");
        }

        return new ResponseEntity<>(vehicleInformationResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/lookup")
    @ResponseBody
    @Produces("application/json")
    public ResponseEntity updateProduct(@RequestParam("vinNumber") String vinNumber, @RequestBody VehicleInformation vehicleInformationResponse) {
        LOGGER.info("Add New Cached Items: ", vinNumber);

        if(vehicleInformationResponse.getYear() == null && vehicleInformationResponse.getMake() == null && vehicleInformationResponse.getModel() == null){

            ErrorCodes errorCodes = new ErrorCodes();
            errorCodes.setInvalidVehicleData(ErrorCodes.INVALID_VEHICLE_DATA);

            return new ResponseEntity<>(errorCodes.getInvalidVehicleData(), HttpStatus.BAD_REQUEST);
        }

        VehicleInformation vehicleInformation = new VehicleInformation();
        vehicleInformation = vehicleInformationResponse;

        vehicleInformationResponse = vehicleInformationService.getVehicleInformation(vinNumber, checkCache);

        if(checkCache.isCheckCache() == true){
            LOGGER.info("VIN is ordered from NHTSA an is added to the cache");
        }else{
            LOGGER.info("VIN is NOT ordered from NHTSA a 2nd time");
        }
        checkCache.setCheckCache(false);

        return new ResponseEntity<>(vehicleInformation, HttpStatus.OK);
    }
}


