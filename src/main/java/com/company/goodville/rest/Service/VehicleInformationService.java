package com.company.goodville.rest.Service;

import Response.VehicleInformation;
import com.company.goodville.rest.Implementation.CheckCache;

public interface VehicleInformationService {

    public VehicleInformation getVehicleInformation(String vinNumber, CheckCache checkCache);
    public VehicleInformation updateVehicleInformation(String vinNumber, VehicleInformation vehicleInformation);

}
