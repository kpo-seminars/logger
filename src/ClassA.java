import logger.Logger;
import logger.LoggerFactory;

public class ClassA {
    private static final Logger logger = LoggerFactory.getLogger(ClassA.class);

    public static void doSomeWork() {
        logger.info("I am doing something");
        logger.debug("Some debug information of doing something");
        logger.debug("Some debug information of doing something");
        logger.debug("Some debug information of doing something");
        logger.debug("Some debug information of doing something");
        logger.debug("Some debug information of doing something");
        logger.debug("Some debug information of doing something");
        logger.debug("Some debug information of doing something");
        logger.error("An error has occurred. Work is not completed!");
    }
}
