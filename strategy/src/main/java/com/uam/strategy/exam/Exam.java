package com.uam.strategy.exam;

import com.google.common.base.Preconditions;

import java.util.List;
import java.util.Map;

public class Exam extends RegularExamEvaluationStrategy {

    private List<ExamQuestion> questions;
    private EvaluationStrategy strategy;

    public Exam(EvaluationStrategy strategy, List<ExamQuestion> questions) {
        Preconditions.checkArgument(!questions.isEmpty(), "Exam have to have at least one question.");
        Preconditions.checkNotNull(strategy);
        this.strategy = strategy;
        this.questions = questions;
    }

    public List<ExamQuestion> getQuestions() {
        return questions;
    }

    public void switchEvaluationStrategy(EvaluationStrategy strategy) {
        Preconditions.checkNotNull(strategy);
        this.strategy = strategy;
    }

    @Override
    public Grade evaluate(Map<ExamQuestion, ExamAnswer> answers) {
        return strategy.evaluate(answers);
    }
}
