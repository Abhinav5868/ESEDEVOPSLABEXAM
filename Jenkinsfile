pipeline {
    agent any
    
    tools {
        jdk 'JAVA_17'
    }
    
    environment {
        DOCKERHUB_CREDS = credentials('dockerhub_token')  // Matches the credential ID from Jenkins
        DOCKER_IMAGE = "your-dockerhub-username/your-app-name"
        DOCKER_TAG = "${BUILD_NUMBER}"
    }
    
    stages {
        stage('Clone') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        
        stage('Docker Build') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }
        
        stage('Docker Push') {
            steps {
                sh 'echo $DOCKERHUB_CREDS_PSW | docker login -u $DOCKERHUB_CREDS_USR --password-stdin'
                sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                sh "docker push ${DOCKER_IMAGE}:latest"
            }
        }
    }
    
    post {
        always {
            sh 'docker logout'
        }
    }
}
