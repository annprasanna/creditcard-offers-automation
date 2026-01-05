pipeline {
    agent any

    tools {
        jdk 'JDK11'        // Must match your Jenkins JDK config
        maven 'Maven3'     // Must match your Jenkins Maven config
    }

    environment {
        WIREMOCK_PORT = 8080
        WIREMOCK_JAR = 'C:\\wiremock\\wiremock-standalone-4.0.0-beta.24.jar' // Update path
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/annprasanna/creditcard-offers-automation.git'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Start WireMock') {
            steps {
                bat """
                start cmd /c java -jar ${env.WIREMOCK_JAR} --port ${env.WIREMOCK_PORT}
                timeout /t 5
                """
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            // Collect test reports
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
