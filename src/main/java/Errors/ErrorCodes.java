package Errors;

public class ErrorCodes {
    public static final String INVALID_VIN_NUMBER = "Please enter a valid VIN Number";

    public static final String INVALID_VEHICLE_DATA = "Please enter year, make and model";

    public String invalidVinNumber;

    public String invalidVehicleData;

    public String getInvalidVinNumber() {
        return invalidVinNumber;
    }

    public void setInvalidVinNumber(String invalidVinNumber) {
        this.invalidVinNumber = invalidVinNumber;
    }

    public String getInvalidVehicleData() {
        return invalidVehicleData;
    }

    public void setInvalidVehicleData(String invalidVehicleData) {
        this.invalidVehicleData = invalidVehicleData;
    }
}
