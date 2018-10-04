#!/bin/sh

pip install pipenv

cd "repo/$SRC_PATH"
pipenv install -d
pipenv run pytest
