#!groovy

pipeline {
    agent any

    tools {
        maven "3.6.0"
    }
	options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean install'
            }
        }
        stage('Test') { 
            steps {
                bat 'mvn test' 
            }
        }
         stage('Deploy') { 
            steps {
               	bat 'mvn deploy -DaltDeploymentRepository=internal.repo::default::https://hub.docker.com/repository/docker/th33ngi/jenkins_deploys'
            }
        }
    }
    post {
    	success {
      		mail to: "th33ngi@gmail.com", 
      		subject:"SUCCESS: ${currentBuild.fullDisplayName}", 
      		body: "Test execution has passed."
    	}
    	failure {
      		mail to: "th33ngi@gmail.com", 
      		subject:"FAILURE: ${currentBuild.fullDisplayName}", 
      		body: "Test execution has passed."
    	}
  }
}