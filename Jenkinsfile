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
            	sh 'chmod ??? $WORKSPACE/src/test/resources/chrome/chromedriver'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}