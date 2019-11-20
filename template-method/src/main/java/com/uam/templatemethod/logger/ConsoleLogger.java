package com.uam.templatemethod.logger;

import java.time.Instant;

public class ConsoleLogger implements Logger {

    private final String className;

    public ConsoleLogger(String className) {
        this.className = className;
    }

    @Override
    public void info(String text) {
        log(format(text), Level.INFO);
    }

    @Override
    public void error(String text) {
        log(format(text), Level.ERROR);
    }

    private String format(String text) {
        return Instant.now() + " [" + className + "]: " + text;
    }

    private void log(String text, Level level) {
        System.out.println("[" + level + "] " + text);
    }
}
