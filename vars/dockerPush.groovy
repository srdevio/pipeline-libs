#!/usr/bin/env groovy

/**
 * Push Docker images in a pipeline
 */

def call(data) {
  echo "PUSHING DOCKER IMAGE"
  service_name = data.env.SERVICE_NAME
  repo_name = data.env.REPO_NAME
  tag_id = data.GIT_COMMIT
//  sh 'printenv'
  sh "gcloud docker -- push ${repo_name}/${service_name}/${service_name}:${tag_id}"
}
