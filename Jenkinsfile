pipeline {
    agent any
	
	tools {
        maven "3.6.0"
    }
	    
    stages {
        stage ('Build Stage') {
            steps {
            	sh "mvn -version"
            	sh "mvn clean compile"
            }
        }
        
        stage ('Test Stage') {
            steps {
            	sh "mvn test"
            	script {
                	sh 'chmod +x -v C:/Users/Th33NGi/jenkins_home:/var/jenkins_home/workspace/.src/test/java/chrome/chromedriver'
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