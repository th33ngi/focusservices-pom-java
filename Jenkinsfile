#!groovy

pipeline {
    agent any

    tools {
        maven "3.6.0"
    }

    stages {
        stage("Build Stage") {
            steps {
                sh "mvn -version"
                sh "mvn clean install"
            }
        }
        stage("Test Stage") {
            steps {
                sh "mvn clean compile test"
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}