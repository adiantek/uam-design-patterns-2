package com.uam.templatemethod.logger;


import com.google.common.base.Preconditions;

import java.time.Instant;

public abstract class AbstractLogger implements Logger {

    private final String className;

    public AbstractLogger(String className) {
        this.className = className;
    }

    @Override
    public void info(String text) {
        validateAndLog(text, Level.INFO);
    }

    @Override
    public void error(String text) {
        validateAndLog(text, Level.ERROR);
    }

    private void validate(String text) {
        Preconditions.checkNotNull(text);
    }

    private String format(String text) {
        return Instant.now() + " [" + className + "]: " + text;
    }

    private void validateAndLog(String text, Level logLevel) {
        validate(text);
        log(format(text), logLevel);
    }

    public abstract void log(String formattedText, Level logLevel);
}
