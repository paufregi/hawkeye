FROM python:3.6-slim

WORKDIR /app

COPY Pipfile /app
COPY main.py /app

ENV PYTHONPATH=/app

RUN pip install pipenv

RUN pipenv lock
RUN pipenv install --system --deploy

CMD []