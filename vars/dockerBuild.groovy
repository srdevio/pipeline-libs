#!/usr/bin/env groovy

/**
 * Build Docker images in a pipeline
 */

def call(data) {
  service_name = data.env.SERVICE_NAME
  echo "SERVICE_NAME: ${service_name}"
  sh 'printenv'
//  sh 'docker build -t ${image} .'
}
