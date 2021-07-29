#!groovy

pipeline {
    agent any

    tools {
        maven "3.6.0"
    }

    stages {
        stage("Build Stage") {
            steps {
            	bat "mvn clean install" 
                bat "mvn -B -DskipTests clean package"
            }
        }
        stage("Test Stage") {
            steps {
                bat "mvn clean test"
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}