package com.studentpredictor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MlPredictorClient {

    public String predictViaApi(Student student) throws Exception {
        String json = String.format(
                "{\"studyHours\": %f, \"attendance\": %f, \"assignmentScore\": %f, \"previousExamScore\": %f}",
                student.studyHours, student.attendance, student.assignmentScore, student.previousExamScore
        );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:5000/predict"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return extractResult(response.body());
    }

    private String extractResult(String rawJson) {
        // Extracts the value of "result" from a simple JSON like {"result":"PASS"}
        String key = "\"result\":\"";
        int start = rawJson.indexOf(key);
        if (start == -1) {
            return "UNKNOWN";
        }
        start += key.length();
        int end = rawJson.indexOf("\"", start);
        return rawJson.substring(start, end);
    }
}