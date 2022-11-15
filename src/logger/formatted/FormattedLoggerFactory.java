package logger.formatted;

import logger.LogLevel;
import logger.Logger;
import logger.LoggerFactory;

public abstract class FormattedLoggerFactory extends LoggerFactory {
    private final String format;

    public FormattedLoggerFactory(String format) {
        this.format = format;
    }

    protected abstract Logger createLogger(String format, LogLevel logLevel, Class<?> clazz);

    public Logger createLogger(LogLevel logLevel, Class<?> clazz) {
        return createLogger(this.format, logLevel, clazz);
    }
}
