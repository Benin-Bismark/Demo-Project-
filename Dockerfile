FROM python:3.11-slim

WORKDIR /app

COPY ml-model-api.py .
COPY student_predictor_model.pkl .

RUN pip install flask scikit-learn pandas numpy joblib flask-cors

EXPOSE 5000

CMD ["python", "ml-model-api.py"]
