package travelOffice;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ApplicationLogger {

    private static Logger logger = Logger.getLogger("com.company.TravelOffice");


    public static Logger getLogger() throws IOException {
        FileHandler fileHandler = new FileHandler("log.txt");
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
        return logger;
    }
}
