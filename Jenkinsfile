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
                bat 'mvn -B -DskipTests clean package'
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
               	bat './mvnw clean deploy'
            }
        }
    }
}