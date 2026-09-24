package com.studentpredictor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PredictorTest {

    @Test
    void highScoringStudentShouldPass() {
        Student student = new Student("Test", 6, 85, 72, 68);
        Predictor predictor = new Predictor();
        assertEquals("PASS", predictor.predict(student));
    }

    @Test
    void lowScoringStudentShouldBeAtRisk() {
        Student student = new Student("Test", 1, 30, 20, 25);
        Predictor predictor = new Predictor();
        assertEquals("AT RISK", predictor.predict(student));
    }
}