pipeline {
    agent any

    tools {
        maven 'Maven 3.9.6'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Vishwas1019/learn_backend-java-.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }

    post {
        success {
            echo '🎉 Build and Tests Success!'
        }
        failure {
            echo '❌ Build Failed!'
        }
    }
}
