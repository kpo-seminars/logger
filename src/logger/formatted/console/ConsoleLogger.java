package logger.formatted.console;

import logger.LogLevel;
import logger.formatted.FormattedLogger;

public class ConsoleLogger extends FormattedLogger {
    public ConsoleLogger(String format, LogLevel logLevel, Class<?> clazz) {
        super(format, logLevel, clazz);
    }

    @Override
    protected void writeLog(String formattedMessage) {
        System.out.println(formattedMessage);
    }
}
