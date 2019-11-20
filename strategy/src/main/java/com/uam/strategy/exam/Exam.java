package com.uam.strategy.exam;

import com.google.common.base.Preconditions;

import java.util.List;

public class Exam {

    private List<ExamQuestion> questions;

    public Exam(List<ExamQuestion> questions) {
        Preconditions.checkArgument(!questions.isEmpty(), "Exam have to have at least one question.");
        this.questions = questions;
    }

    public List<ExamQuestion> getQuestions() {
        return questions;
    }
}
