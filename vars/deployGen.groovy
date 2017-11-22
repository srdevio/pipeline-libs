#!/usr/bin/env groovy

/**
 * Build Docker images in a pipeline
 */

def call(data, env) {
  echo "DEPLOYING TO ENV: ${env}"
  service_name = data.env.SERVICE_NAME
  repo_name = data.env.REPO_NAME
  tag_id = data.GIT_COMMIT
//  sh 'printenv'
  echo 'Deploying to pants'
  sh "sed -i.bak 's/\${build_number}/${tag_id}/g' deployment.yml"
  sh "sed -i.bak 's/\${image_name}/${service_name}/g' deployment.yml"
  sh "kubectl config use-context ${env}"
  sh 'kubectl apply --record=true -f deployment.yml'
  sh "kubectl rollout status deployment ${service_name}"
//  sh 'ls'
//  sh "gsutil cp deployment.yml Dockerfile gs://sr-deployment-artifacts/${service_name}/${tag_id}/"
//  sh "gsutil ls gs://sr-deployment-artifacts/${service_name}/${tag_id}/"
}
