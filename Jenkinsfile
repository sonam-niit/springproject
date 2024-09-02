pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/sonam-niit/springproject.git'

                // Run Maven Wrapper Commands
                bat "./mvnw compile"

                echo 'Building the Project with maven compile'
            }
        }

        stage('Test') {
            steps {
                // Run Maven Wrapper Commands
                bat "./mvnw test"

                echo 'Testing the Project with maven test'
            }
        }

        stage('Package') {
            steps {
                // Run Maven Wrapper Commands
                bat "./mvnw package"

                echo 'Packaging the Project with maven package'
            }
        }

        stage('Containerize') {
            steps {
                // Build Docker image
                bat "docker build -t myapp ."

                echo 'Containerizing the App with Docker'
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Check if the container is running
                    def containerRunning = bat(script: 'docker ps -q -f name=sbapp', returnStdout: true).trim()
                    if (containerRunning) {
                        // Stop and remove the running container
                        bat "docker stop sbapp"
                        bat "docker rm sbapp"
                    }
                }

                // Run Docker container
                bat "docker run -d --name sbapp -p 9090:8082 myapp"

                echo 'Deploying the App with Docker'
            }
        }
    }
}
