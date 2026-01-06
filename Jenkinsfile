pipeline {
    agent any

    // Commented out tools if you don't have JDK11 in Jenkins
     tools {
         jdk 'JDK21'
         maven 'Maven3'
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
                echo "Starting WireMock on port ${env.WIREMOCK_PORT}"
                bat """
                start cmd /c java -jar ${env.WIREMOCK_JAR} --port ${env.WIREMOCK_PORT}
                timeout /t 5
                """
            }
        }

        stage('Run Tests') {
            steps {
                echo "Running TestNG + Cucumber Tests"
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            // Publish both TestNG and Cucumber reports
            junit '**/target/surefire-reports/*.xml'
            junit '**/target/surefire-reports/Cucumber.xml'
        }
    }
}
