package logger.formatted.console;

import logger.LogLevel;
import logger.Logger;
import logger.formatted.FormattedLoggerFactory;

public class ConsoleLoggerFactory extends FormattedLoggerFactory {
    public ConsoleLoggerFactory(String format) {
        super(format);
    }

    @Override
    protected Logger createLogger(String format, LogLevel logLevel, Class<?> clazz) {
        return new ConsoleLogger(format, logLevel, clazz);
    }

}
