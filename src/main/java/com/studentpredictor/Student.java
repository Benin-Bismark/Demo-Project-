package com.studentpredictor;

public class Student {

    String name;
    double studyHours;
    double attendance;
    double assignmentScore;
    double previousExamScore;

    public Student(String name, double studyHours, double attendance,
                   double assignmentScore, double previousExamScore) {

        this.name = name;
        this.studyHours = studyHours;
        this.attendance = attendance;
        this.assignmentScore = assignmentScore;
        this.previousExamScore = previousExamScore;
    }
}