#!/bin/bash

set -e

if [ "$TRAVIS_BRANCH" == "master" ]; then
	docker login -u="$DOCKER_USERNAME" -p="$DOCKER_PASSWORD";
	docker build -t "$PROJECT_NAME:latest" .;
	docker push "$DOCKER_USERNAME/$PROJECT_NAME:latest";
fi