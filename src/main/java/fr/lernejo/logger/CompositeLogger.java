package fr.lernejo.logger;

public class CompositeLogger implements  Logger{

    FilteredLogger filteredLogger;
    ConsoleLogger consoleLogger;

    public CompositeLogger(FilteredLogger filteredLogger, ConsoleLogger consoleLogger){
        this.filteredLogger = filteredLogger;
        this.consoleLogger = consoleLogger;
    }
    @Override
    public void log(String message) {
        filteredLogger.log(message);
        consoleLogger.log(message);
    }
}
