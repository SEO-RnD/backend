pipeline {
  agent {
    docker {
      image 'thanosmourtk/dind-java-mvn:java21-mvn4'
      args '''
        --privileged
        --cgroupns=host
        -v /sys/fs/cgroup:/sys/fs/cgroup:rw
        -e DOCKER_TLS_CERTDIR=
        -v dind-data:/var/lib/docker
        -v $WORKSPACE/.m2:/root/.m2
      '''
      reuseNode true
    }
  }

  stages {
    stage('Build') {
      steps {
        sh '''
          set -eux
          mvn clean install -B
        '''
      }
    }
  }

  post {
    success {
      echo "✅ Maven build finished successfully"
    }
    failure {
      echo "❌ Maven build failed"
    }
  }
}
