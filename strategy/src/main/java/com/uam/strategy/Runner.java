package com.uam.strategy;

import com.uam.strategy.exam.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        DummyDataBuilder dataBuilder = new DummyDataBuilder();

        Exam exam = dataBuilder.buildExam(new ComboEvaluationStrategy());
        List<FinishedExam> finishedExams = dataBuilder.getFinishedExams(exam);

        // use regular exam evaluate strategy
        System.out.println("Tested as regular exam:");
        finishedExams
                .stream()
                .map(FinishedExam::evaluate)
                .forEachOrdered(System.out::println);


        // switch evaluation strategy
        exam.switchEvaluationStrategy(new FinalExamEvaluationStrategy());

        // use final exam evaluate strategy
        System.out.println("Tested as final exam:");

        finishedExams
                .stream()
                .map(FinishedExam::evaluate)
                .forEachOrdered(System.out::println);
    }
}
