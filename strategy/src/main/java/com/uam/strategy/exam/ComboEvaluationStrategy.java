package com.uam.strategy.exam;

import java.util.Map;

public class ComboEvaluationStrategy implements EvaluationStrategy {

    @Override
    public Grade evaluate(Map<ExamQuestion, ExamAnswer> answers) {
        int correct = 0;
        int combo = 1;
        int total = (1 + answers.size()) * answers.size() / 2;
        for (Map.Entry<ExamQuestion, ExamAnswer> entr : answers.entrySet()) {
            if (entr.getKey().getCorrectAnswer().equals(entr.getValue())) {
                correct += combo;
                combo++;
            } else {
                combo = 1;
            }
        }
        if (correct > total) {
            throw new IllegalStateException("correct > total");
        }
        int grade = correct * (Grade.values().length - 1) / total;
        return Grade.values()[Grade.values().length - grade - 1];
    }
}
