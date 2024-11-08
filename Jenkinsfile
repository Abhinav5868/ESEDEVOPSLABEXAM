pipeline {
    agent any
    
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub_token')
        DOCKER_IMAGE = "your-dockerhub-username/your-app-name"
        DOCKER_TAG = "${BUILD_NUMBER}"
    }
    
    stages {
        stage('Clone') {
            steps {
                // Remove the explicit git step since checkout is already done
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
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
            }
        }
    }
    
    post {
        always {
            sh 'docker logout'
        }
    }
}
