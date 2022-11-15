package logger;

public interface Logger {
    void log(LogLevel logLevel, String message);

    default void error(String message) {
        log(LogLevel.ERROR, message);
    }

    default void info(String message) {
        log(LogLevel.INFO, message);
    }

    default void debug(String message) {
        log(LogLevel.DEBUG, message);
    }
}
