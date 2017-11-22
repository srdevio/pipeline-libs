#!/usr/bin/env groovy

/**
 * Build Docker images in a pipeline
 */

def call(data) {
  echo "${data.env.SERVICE_NAME}"
  sh 'printenv'
//  sh 'docker build -t ${image} .'
}
