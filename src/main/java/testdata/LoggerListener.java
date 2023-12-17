package testdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerListener {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LoggerListener.class);
        logger.error("Here is an error");
        logger.info("Information error");


    }

}
