package models.loggers;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Logger;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logInfo(String dateTime, String message) {
        logMessage(dateTime, message, ReportLevel.INFO);
    }

    @Override
    public void logWarning(String dateTime, String message) {
        logMessage(dateTime, message, ReportLevel.WARNING);
    }

    @Override
    public void logError(String dateTime, String message) {
        logMessage(dateTime, message, ReportLevel.ERROR);
    }

    @Override
    public void logCritical(String dateTime, String message) {
        logMessage(dateTime, message, ReportLevel.CRITICAL);
    }

    @Override
    public void logFatal(String dateTime, String message) {
        logMessage(dateTime, message, ReportLevel.FATAL);
    }

    private void logMessage(String dateTime, String message, ReportLevel reportLevel) {
        for (Appender appender : this.appenders) {
            appender.appendMessage(dateTime, reportLevel, message);
        }
    }

    public String getLogInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Logger info");

        for (Appender appender : this.appenders) {
            sb.append(System.lineSeparator())
                    .append(appender);
        }

        return sb.toString();
    }
}
