package com.uam.strategy.exam;

import java.util.Map;

public class RegularExamEvaluationStrategy implements EvaluationStrategy {

    public Grade evaluate(Map<ExamQuestion, ExamAnswer> answers) {
        int correct = 0;
        int total = answers.size();
        for (Map.Entry<ExamQuestion, ExamAnswer> entr : answers.entrySet()) {
            if (entr.getKey().getCorrectAnswer().equals(entr.getValue())) {
                correct++;
            }
        }
        int grade = correct * (Grade.values().length - 1) / total;
        return Grade.values()[Grade.values().length - grade - 1];
    }
}
