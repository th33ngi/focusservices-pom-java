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
                //bat 'mvn -B -DskipTests clean package' -->
                bat 'mvn verify'
            }
        }
        stage('Test') { 
            steps {
                bat 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
         stage('Deploy') { 
            steps {
               	bat 'mvn deploy'
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