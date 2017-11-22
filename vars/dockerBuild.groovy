#!/usr/bin/env groovy

/**
 * Build Docker images in a pipeline
 */

def call(String image = 'NULL') {
  echo "${image}"
  sh 'printenv'
  sh 'docker build -t ${image} .'
}
