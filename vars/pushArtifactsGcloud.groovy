#!/usr/bin/env groovy

/**
 * Build Docker images in a pipeline
 */

def call(data) {
  echo "PUSHING ARTIFACTS TO GS"
  service_name = data.env.SERVICE_NAME
  repo_name = data.env.REPO_NAME
  tag_id = data.GIT_COMMIT
//  sh 'printenv'
  sh 'ls'
  sh "gsutil cp deployment.yml Dockerfile gs://sr-deployment-artifacts/${service_name}/${tag_id}/"
  sh 'gsutil ls gs://sr-deployment-artifacts/${service_name}/${tag_id}/'
}
