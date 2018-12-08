package loggingtool;

import java.util.logging.Logger;

public class LogFile {

    private static Logger logger = Logger.getLogger("");

    public static void getLogFile(String msg) throws Exception {
        logger.info(msg);

    }

}
