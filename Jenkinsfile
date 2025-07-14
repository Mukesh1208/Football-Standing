pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'football-standings-service:latest'
    }

    tools {
        maven 'Maven 3.9.10'
        jdk 'jdk24'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Mukesh1208/Football-Standing.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t %DOCKER_IMAGE% .'
            }
        }

        stage('Docker Run') {
            steps {
                bat 'docker run -d -p 8080:8080 --name standings-service %DOCKER_IMAGE%'
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
        success {
            echo 'Deployment successful.'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
