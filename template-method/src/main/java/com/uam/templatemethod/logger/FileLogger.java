package com.uam.templatemethod.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.time.LocalDate;

public class FileLogger implements Logger {

    private final String className;

    public FileLogger(String className) {
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
        String currentFileName = calculateCurrentFileName(level);
        Path pathToLogFile = Paths.get(currentFileName);

        if (Files.exists(pathToLogFile)) {
            writeToFile(pathToLogFile, text, StandardOpenOption.APPEND);
        } else {
            writeToFile(pathToLogFile, text, StandardOpenOption.CREATE);
        }
    }

    private String calculateCurrentFileName(Level level) {
        return "log-" + LocalDate.now() + (level.equals(Level.INFO) ? "-infos" : "-errors");
    }

    private void writeToFile(Path path, String textToPrint, StandardOpenOption standardOpenOption) {
        try {
            Files.write(path, (textToPrint + "\n").getBytes(), standardOpenOption);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
