pipeline{
    agent any
    tools{
        maven 'Maven'
        jdk 'java21'
    }

    stages{
        stage('checkout'){
            steps{
                git branch: 'main', url: 'https://github.com/Pawaffle/InclassAikido.git'
            }
        }

        stage('build'){
            steps{
                bat 'mvn clean install'
            }
        }

        stage('test'){
            steps{
                bat 'mvn test'
            }
        }

        stage('Test & Coverage') {
                    steps {
                        bat 'mvn test jacoco:report' // Runs tests & generates JaCoCo coverage report
                    }
                    post {
                        always {
                            junit 'target/surefire-reports/*.xml' // Publish JUnit test results

                            // Discover reference build for comparison
                            discoverReferenceBuild()

                            // Record Coverage using Coverage Plugin
                            recordCoverage(
                                tools: [[parser: 'JACOCO']],
                                id: 'jacoco',
                                name: 'JaCoCo Coverage',
                                sourceCodeRetention: 'EVERY_BUILD',
                                qualityGates: [
                                    [threshold: 60.0, metric: 'LINE', baseline: 'PROJECT', unstable: true],
                                    [threshold: 60.0, metric: 'BRANCH', baseline: 'PROJECT', unstable: true]
                                ]
                            )
                        }
                    }
                }
    }
}