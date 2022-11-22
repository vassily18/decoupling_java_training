package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
    public static CompositeLogger getLogger(String name){
        Predicate<String> condition = (message) -> (message.contains("simulation"));
        return new CompositeLogger(new FilteredLogger(new FileLogger("/tmp/" + name),condition), new ConsoleLogger());
    }
}
