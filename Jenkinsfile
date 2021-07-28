pipeline {
    agent any
    
    stages {
        stage ('Compile Stage') {
            steps {
            	sh 'mvn -version'
            	sh 'mvn clean compile'
            }
        }
        
        stage ('Testing Stage') {
            steps {
            	sh 'mvn test'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}