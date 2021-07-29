#!groovy

pipeline {
    agent any
    
    tools {
        maven "3.6.0"
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
               	bat 'mvn -B -DskipTests deploy -DaltDeploymentRepository=internal.repo::default::file:file:///C:/Users/Th33NGi/Documents/jenkins_deployments'
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}