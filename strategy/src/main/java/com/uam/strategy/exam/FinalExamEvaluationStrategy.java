package com.uam.strategy.exam;

import java.util.Map;

public class FinalExamEvaluationStrategy implements EvaluationStrategy {

    public Grade evaluate(Map<ExamQuestion, ExamAnswer> answers) {
        return Grade.A;
    }
}
