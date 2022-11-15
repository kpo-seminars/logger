package logger.formatted;

import logger.LogLevel;
import logger.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class FormattedLogger implements Logger {
    private final String format;
    private final LogLevel logLevel;
    private final Class<?> clazz;

    public FormattedLogger(String format, LogLevel logLevel, Class<?> clazz) {
        this.format = format;
        this.logLevel = logLevel;
        this.clazz = clazz;
    }

    protected abstract void writeLog(String formattedMessage);

    @Override
    public void log(LogLevel logLevel, String message) {
        if (logLevel.ordinal() > this.logLevel.ordinal()) {
            return;
        }

        String formattedMessage = format
                .replaceAll("%level%", padLeftSpaces(logLevel.toString(), 5))
                .replaceAll("%class%", padLeftSpaces(clazz.getName(), 10))
                .replaceAll("%date%", getFormattedDate())
                .replaceAll("%message%", message);

        writeLog(formattedMessage);
    }

    /*
     * Private methods
     */
    private String getFormattedDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    private String padLeftSpaces(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }

        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append(' ');
        }
        sb.append(inputString);

        return sb.toString();
    }
}
