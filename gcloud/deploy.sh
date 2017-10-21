#!/bin/bash

set -e

docker build -t "$DOCKER_USERNAME/$PROJECT_NAME" -t "gcr.io/$GCLOUD_PROJECT_ID/$PROJECT_NAME" .;

if [ "$TRAVIS_BRANCH" == "master" ]; then
	docker login -u="$DOCKER_USERNAME" -p="$DOCKER_PASSWORD";
	docker push "$DOCKER_USERNAME/$PROJECT_NAME";
fi

echo $GCLOUD_SERVICE_KEY | base64 --decode -i > $GOOGLE_APPLICATION_CREDENTIALS
gcloud auth activate-service-account --key-file $GOOGLE_APPLICATION_CREDENTIALS
gcloud docker -- push "gcr.io/$GCLOUD_PROJECT_ID/$PROJECT_NAME"