pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'mvn clean package'
      }
    }

    stage('test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('deploy') {
      steps {
        sh 'cp /root/.jenkins/workspace/SisPromo_master/target/SistPromo.war /opt/wildfly/standalone/deployments'
      }
    }

  }
}