# Student Performance Predictor

A demo project built to learn a full end-to-end software delivery workflow — from version control and testing to CI/CD, machine learning, and containerization. It predicts whether a student will **PASS**, **NEED IMPROVEMENT**, or is **AT RISK**, based on study hours, attendance, assignment score, and previous exam score.

## Overview

This project combines a rule-based Java prediction engine with a trained Machine Learning model, exposed via a Python API and consumed through a simple browser dashboard. It was built in stages to practice a realistic professional workflow: Git/GitHub, Maven, JUnit, SonarQube, Jenkins, Python/scikit-learn, Flask, and Docker.

## Tech Stack

- **Java 21** — core rule-based prediction logic
- **Maven** — build and dependency management
- **JUnit 5** — unit testing
- **SLF4J** — logging
- **SonarQube** — static code analysis
- **Jenkins** — CI pipeline (build + test on push)
- **Python (scikit-learn, pandas, joblib)** — ML model training
- **Flask** — REST API serving the trained model
- **Docker** — containerization of the ML API
- **HTML/JavaScript** — browser dashboard frontend

## Architecture

Try:
|
Browser Dashboard (dashboard.html)
│ fetch() POST /predict
▼
Flask ML API (containerized in Docker)
│ loads
▼
student_predictor_model.pkl (Logistic Regression)

Java Application
│
├── Predictor.java → rule-based prediction (formula-driven)
└── MlPredictorClient.java → calls Flask API via HTTP, parses JSON result


## Project Stages
Stage	Description
1	GitHub + IntelliJ setup, Git branching workflow
2	Converted to Maven project structure
3	Added JUnit tests (PredictorTest.java)
4	SonarQube static analysis — resolved maintainability issues (replaced System.out with SLF4J logging)
5	Jenkins pipeline — automatic build & test on GitHub push
6	Trained ML model (Logistic Regression, 93.3% accuracy) on synthetic student data
7	Connected Java app to the ML model via a Flask API (/predict endpoint)
8	Containerized the Flask API with Docker; added a browser dashboard for live predictions
How the Prediction Works
Rule-based (Java):

score = (studyHours * 5) + (attendance * 0.3) + (assignmentScore * 0.2) + (previousExamScore * 0.3)

score >= 70 → PASS
score >= 50 → NEED IMPROVEMENT
score <  50 → AT RISK
ML-based (Python): A Logistic Regression model trained on synthetic data generated using the same underlying formula, then evaluated against a held-out test set (93.3% accuracy).

Running the Project
1. Run the ML API (Docker)
   bash
   Copy
   docker build -t student-predictor-ml-api .
   docker run -p 5000:5000 student-predictor-ml-api
   Try:
   |
2. Run the ML API (without Docker, alternative)
   bash
   Copy
   python -m venv venv
   venv\Scripts\activate
   pip install flask flask-cors scikit-learn pandas numpy joblib
   python ml-model-api.py
   Try:
   |
3. Run the Java application
   Open the project in IntelliJ and run Main.java. It will print both the rule-based prediction and the ML API prediction to the console.

4. Use the browser dashboard
   Open dashboard.html in any browser (with the API running) to enter a student's details and get a live prediction.

Testing
Run unit tests with:

bash
Copy
mvn test
Try:
|
Code Quality
Static analysis was performed with SonarQube:

bash
Copy
mvn clean verify sonar:sonar -Dsonar.projectKey=<your-project-key> -Dsonar.host.url=<your-sonar-url> -Dsonar.login=<your-token>
Try:
|
CI/CD
A Jenkins Pipeline job is configured to automatically build and test the project on every push to GitHub, running:

bash
Copy
mvn clean compile
mvn test
Try:
|
Repository
github.com/Benin-Bismark/Demo-Project-

Notes
This is a personal learning project built to understand a complete modern software development workflow before applying the same practices to a larger capstone project. The ML model was trained on synthetic data generated from a known formula, intended to demonstrate the ML pipeline (data generation → training → evaluation → model selection → deployment) rather than to produce a production-grade predictive model.