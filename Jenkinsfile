#!groovy

pipeline {
    agent any

    tools {
        maven "3.6.0"
    }

    stages {
        stage("Build") {
            steps {
                sh "mvn -version"
                sh "mvn clean install"
            }
        }
        
        stage("Tests Execution") {
            steps {
            	script {
            		sh 'chmod +x /var/jenkins_home/workpace/maven-pipeline/./src/test/resources/chrome/chromedriver'
            	}
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}