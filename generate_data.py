import pandas as pd
import numpy as np

np.random.seed(42)
n = 300

study_hours = np.random.uniform(0, 10, n)
attendance = np.random.uniform(0, 100, n)
assignment_score = np.random.uniform(0, 100, n)
previous_exam_score = np.random.uniform(0, 100, n)

score = (study_hours * 5) + (attendance * 0.3) + (assignment_score * 0.2) + (previous_exam_score * 0.3)

def classify(s):
    if s >= 70:
        return "PASS"
    elif s >= 50:
        return "NEED IMPROVEMENT"
    else:
        return "AT RISK"

result = [classify(s) for s in score]

df = pd.DataFrame({
    "study_hours": study_hours,
    "attendance": attendance,
    "assignment_score": assignment_score,
    "previous_exam_score": previous_exam_score,
    "result": result
})

df.to_csv("student_data.csv", index=False)
print("Dataset generated:", df.shape)
print(df["result"].value_counts())