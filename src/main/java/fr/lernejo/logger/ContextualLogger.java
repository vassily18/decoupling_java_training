package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{

    DateTimeFormatter formatter;
    String callerClass = "";

    Logger delegateLogger;

    public ContextualLogger(String callerClass, Logger log){
        this.callerClass = callerClass;
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        delegateLogger = log;
    }
    public void log(String message) {
        delegateLogger.log(LocalDateTime.now().format(formatter) + " [" + callerClass + "]: " + message);
    }
}
