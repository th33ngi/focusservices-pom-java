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
    }

    post {
        always {
            cleanWs()
        }
    }
}