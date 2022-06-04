/*
Chỉ có thể define pipeline trong vars và chỉ có thể ở trong call method
*/

def call(int buildNumber) {
    if (buildNumber % 2 == 0) {
        pipeline {
            agent any
            stages {
                stage('Even Stage') {
                    steps {
                        echo "The build number is even"
                    }
                }
            }
        }
    } else {
        pipeline {
            agent any
            stages {
                stage('Odd Stage') {
                    steps {
                        echo "The build number is odd"
                    }
                }
            }
        }
    }
}