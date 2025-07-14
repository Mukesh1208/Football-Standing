pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'football-standings-service:latest'
    }

    tools {
        maven 'Maven 3.9.10' // match your Jenkins config
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
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Docker Run') {
            steps {
                sh 'docker run -d -p 8080:8080 --name standings-service $DOCKER_IMAGE'
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
