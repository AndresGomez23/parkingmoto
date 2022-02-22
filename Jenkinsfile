@Library('ceiba-jenkins-library')
pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK8_Centos' //Verisión preinstalada en la Configuración del Master
  }
/*	Versiones disponibles
      JDK8_Mac
      JDK6_Centos
      JDK7_Centos
      JDK8_Centos
      JDK10_Centos
      JDK11_Centos
      JDK13_Centos
      JDK14_Centos
*/

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        		 			checkout([$class: 'GitSCM',
        		 			branches: [[name: '*/Master']],
        					doGenerateSubmoduleConfigurations: false,
        					extensions: [],
        					gitTool: 'Git_Centos',
        					submoduleCfg: [],
        					userRemoteConfigs:
        						[[
        							credentialsId: 'Andres.Naranjo',
        							url: 'https://github.com/AndresGomez23/parkingmoto.git'
        						]]])

        					sh 'gradle clean'
      }
    }

    stage('Compile & Unit Tests') {
      steps{
        echo "------------>Compile<------------"
        					sh 'gradle --b ./build.gradle compileJava'

        echo "------------>Unit Tests<------------"
        		 			sh 'gradle --stacktrace test'
        					junit '**/build/test-results/test/*.xml' //aggregate test results - JUnit
        					step( [ $class: 'JacocoPublisher' ] )
      }
    }

    stage('Static Code Analysis') {
        steps{
            	sonarqubeMasQualityGatesP(sonarKey:'co.com.ceiba.adn:parkingmotoandresnaranjo',
            sonarName:'CeibaADN-ParkingMotoAndresNaranjo',
            sonarPathProperties:'./sonar-project.properties')
        }
    }


    stage('Build') {
          steps{
                echo "------------>Build<------------"
                //Construir sin tarea test que se ejecutó previamente
                sh './gradlew --b ./build.gradle build -x test'
    }
    }

  post {
    always {
      echo 'This will always run'
    }

    success {
    			echo 'This will run only if successful'
    junit 'build/test-results/test/*.xml' //RUTA RELATIVA DE LOS ARCHIVOS .XML
    }

    failure {
      echo 'This will run only if failed'
      	 		mail (to: 'andres.naranjo@ceiba.com.co',
      			      subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
      			      body: "Something is wrong with ${env.BUILD_URL}")
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}
