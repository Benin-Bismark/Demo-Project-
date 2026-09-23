package com.studentpredictor;

public class Predictor {

    public String predict(Student student) {

        double score =
                (student.studyHours * 5)
                        + (student.attendance * 0.3)
                        + (student.assignmentScore * 0.2)
                        + (student.previousExamScore * 0.3);

        if (score >= 70) {
            return "PASS";
        } else if (score >= 50) {
            return "NEED IMPROVEMENT";
        } else {
            return "AT RISK";
        }
    }
}