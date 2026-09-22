package com.studentpredictor;

public class Main {

    public static void main(String[] args) {

        Student student = new Student(
                "Bismarck",
                6,
                85,
                72,
                68
        );

        Predictor predictor = new Predictor();

        String result = predictor.predict(student);

        System.out.println("-----------------------------");
        System.out.println("Student Performance Predictor");
        System.out.println("-----------------------------");
        System.out.println("Student: " + student.name);
        System.out.println("Prediction: " + result);
    }
}