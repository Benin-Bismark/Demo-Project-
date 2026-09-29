from flask import Flask, request, jsonify
import joblib
import pandas as pd

from flask import Flask, request, jsonify
from flask_cors import CORS
import joblib
import pandas as pd

app = Flask(__name__)
CORS(app)
model = joblib.load("student_predictor_model.pkl")



@app.route("/predict", methods=["POST"])
def predict():
    data = request.get_json()

    features = pd.DataFrame([{
        "study_hours": data["studyHours"],
        "attendance": data["attendance"],
        "assignment_score": data["assignmentScore"],
        "previous_exam_score": data["previousExamScore"]
    }])

    prediction = model.predict(features)[0]

    return jsonify({"result": prediction})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)