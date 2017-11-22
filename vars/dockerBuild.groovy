#!/usr/bin/env groovy

/**
 * Build Docker images in a pipeline
 */

def call(data) {
  service_name = data.env.SERVICE_NAME
  repo_name = data.env.REPO_NAME
  tag_id = data.GIT_COMMIT
  echo "SERVICE_NAME: ${service_name}"
  echo "REPO_NAME: ${repo_name}"
  echo "TAG_ID: ${tag_id}"
//  sh 'printenv'
  sh "docker build -t ${repo_name}/${service_name}:${tag_id} ."
}
