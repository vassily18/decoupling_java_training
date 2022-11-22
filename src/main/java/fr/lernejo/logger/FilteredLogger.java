package fr.lernejo.logger;

import java.util.function.Predicate;

public class FilteredLogger implements Logger{

    Predicate<String> condition;
    FileLogger delegate;

    public FilteredLogger(FileLogger delegate, Predicate<String> condition) {
        this.condition = condition;
        this.delegate = delegate;
    }

    public void log(String message) {
        if (condition.test(message)){
            delegate.log(message);
        }
    }
}
