#!/usr/bin/env groovy

/**
 * Deploy to a given k8s cluster
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
  hipchatSend (color: 'YELLOW', credentialId: 'qaNc1SSn60HyK0FVk09j1ZQ9yOfn9uubScUarD01', failOnError: true, message: 'test', notify: true, room: '4018492', sendAs: 'Jenkins', server: 'api.hipchat.com', textFormat: true, v2enabled: true)
}
