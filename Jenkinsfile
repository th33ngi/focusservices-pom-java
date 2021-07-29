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
            }
        }
        stage("Test Stage") {
            steps {
                bat "./test/java/testng.xml"
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}