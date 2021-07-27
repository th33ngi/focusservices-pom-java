pipeline {
	agent any	
	stages {
		stage ("Build") {
			steps {
				sh "nvm -version"
				sh "nvm clean install"
			}
		}
	}
	
	post {
		always {
			cleanWs()
		}
	}
}