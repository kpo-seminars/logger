package logger;

public abstract class LoggerFactory {
    private static LoggerFactory instance;
    private static LogLevel logLevel;

    protected LoggerFactory() {
    }

    public static Logger getLogger(Class<?> clazz) {
        if (instance == null) {
            throw new IllegalStateException("Logger factory is not registered");
        }

        return instance.createLogger(logLevel, clazz);
    }

    public static void register(LogLevel logLevel, LoggerFactory instance) {
        if (LoggerFactory.instance != null) {
            throw new IllegalStateException("Logger factory is already registered");
        }

        LoggerFactory.logLevel = logLevel;
        LoggerFactory.instance = instance;
    }

    public abstract Logger createLogger(LogLevel logLevel, Class<?> clazz);
}
