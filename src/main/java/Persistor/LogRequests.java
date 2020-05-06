package Persistor;

import Response.VehicleInformation;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogRequests {

    Logger logger = Logger.getLogger("VehicleInformationLog");
    FileHandler fh;

    public void logRequests (VehicleInformation vehicleInformation, String vinNumber) {

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("C:/temp/VehicleInformationLogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.info("Vin Number: " + vinNumber);
            logger.info("Vehicle Year: " + vehicleInformation.getYear());
            logger.info("Vehicle Make: " + vehicleInformation.getMake());
            logger.info("Vehicle Model: " + vehicleInformation.getModel());

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        logger.info("Hi Isaiah!");
    }
}
