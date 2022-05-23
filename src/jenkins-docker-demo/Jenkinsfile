pipeline {
    agent {
        docker { image 'node:16.13.1-alpine' }
    }

    environment {
        DISABLE_AUTH = 'true'
        DB_ENGINE    = 'sqlite'
    }

    stages {
        stage('Test') {
            steps {
                sh 'node --version'
            }
        }
        stage('Build') {
            steps {
                sh 'npm install'
                echo "Database engine is ${DB_ENGINE}"
                echo "DISABLE_AUTH is ${DISABLE_AUTH}"
                sh 'printenv'
            }
        }

         stage('Deploy') {
            steps {
                echo 'Deploying'
            }
        }
    }

    post {
        always {
            echo 'One way or another, I have finished'
            //deleteDir() /* clean up our workspace */
        }
        success {
            echo 'I succeeded!'
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed :('
        }
        changed {
            echo 'Things were different before...'
        }
    }
}