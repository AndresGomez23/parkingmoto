stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout scm
      }
    }

stage('Compile & Unit Tests') {
    steps{
    echo "------------>compile & Unit Tests<------------"
    sh 'chmod +x gradlew'
    sh './gradlew --b ./build.gradle test'
    }
    }

stage('NPM Install') {
      steps {
        echo "------------>Installing<------------"
        sh 'npm install'
      }
    }
    stage('Unit Test') {
      steps {
        echo "------------>Testing<------------"
        sh 'npm run test'
      }
    }
    stage('Test end-to-end') {
      steps{
        echo "------------>Testing Protractor<------------"
        sh 'npm run e2e'
      }
    }


