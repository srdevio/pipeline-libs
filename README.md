# pipeline-libs
## Usage
To use these libs in a Jenkins file put the following at the top:
```
#!groovy

//Use Shared libs
@Library('pipeline-libs@master') _
```
Be sure to put the _ (underscore) at the end of the last pipeline

To reference the libs in a jenkins file:
```
stage('Build') {
  agent any
  steps {
    // From shared libs. Assumes SERVICE_NAME and REPO_NAME exist.
    dockerBuild this
  }
}
```
In the code above dockerBuild is the name of the lib. Passing 'this' to it gives it access to all vars and objects etc.


