package com.uam.templatemethod.logger;


public abstract class AbstractLogger implements Logger {

    private final String className;

    public AbstractLogger(String className) {
        this.className = className;
    }

    @Override
    public void info(String text) {
    }

    @Override
    public void error(String text) {
    }
}
