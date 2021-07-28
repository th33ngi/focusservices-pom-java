#!groovy

pipeline {
    agent any
    
    stages {
        stage("Build") {
            steps {
            	withMaven(maven : '3.6.0'){
            		sh 'mvn clean compile'
            	}
            }
        }
        
        stage('Testing Stage') {
            steps {
            	withMaven(maven : '3.6.0'){
            		sh 'mvn test'
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