pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            when {
                branch "fix-*"
            }
            steps {
                echo 'Deploying....'
                sh '''
                cat README.md
                '''
            }
        }
    }
}
