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
  hipchatSend (color: 'YELLOW', credentialId: 'rgifford-hipchat-api-send-only2', failOnError: false, message: "Just deployed ${service_name}:${tag_id} to ${env}. Thought you should know.  ${BLUE_OCEAN_URL}", notify: true, room: '4018492', sendAs: 'Jenkins', server: 'api.hipchat.com', textFormat: true, v2enabled: true)
}
