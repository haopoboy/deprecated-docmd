#!/bin/bash

set -e
mv $(ls -t target/*.jar | head -n 1) target/app.jar
docker build -t "$DOCKER_USERNAME/$PROJECT_NAME" -t "gcr.io/$GCLOUD_PROJECT_ID/$PROJECT_NAME" .

if [ "$TRAVIS_BRANCH" == "master" ]; then
    docker login -u="$DOCKER_USERNAME" -p="$DOCKER_PASSWORD"
    docker push "$DOCKER_USERNAME/$PROJECT_NAME"
    docker logout

elif [ "$TRAVIS_BRANCH" == "gcloud" ]; then
    echo $GCLOUD_SERVICE_KEY | base64 --decode -i > $GOOGLE_APPLICATION_CREDENTIALS
    gcloud auth activate-service-account --key-file $GOOGLE_APPLICATION_CREDENTIALS
    gcloud docker -- push "gcr.io/$GCLOUD_PROJECT_ID/$PROJECT_NAME"
fi


