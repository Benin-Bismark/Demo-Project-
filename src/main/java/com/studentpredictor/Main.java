package com.studentpredictor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

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

        logger.info("------------------------");
        logger.info("Student Performance Predictor");
        logger.info("------------------------");
        logger.info("Student: {}", student.name);
        logger.info("Prediction: {}", result);
    }
}