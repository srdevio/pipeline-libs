#!/usr/bin/env groovy

/**
 * Build Docker images in a pipeline
 */

def call(data) {
  echo "BUILDING DOCKER IMAGE"
  service_name = data.env.SERVICE_NAME
  repo_name = data.env.REPO_NAME
  tag_id = data.GIT_COMMIT
//  sh 'printenv'
  sh "docker build -t ${repo_name}/${service_name}:${tag_id} ."
}
