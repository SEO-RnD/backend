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
        sh 'set -eux; mvn clean install -B'
      }
    }
    stage('Notify Discord') {
      when { expression { true } }     // always run
      steps {
        script {
          def ok    = (currentBuild.currentResult ?: 'SUCCESS') == 'SUCCESS'
          def title = ok ? 'Jenkins: Build passed ✅' : 'Jenkins: Build failed ❌'
          def color = ok ? 3066993 /*green*/ : 15158332 /*red*/

          withCredentials([string(credentialsId: 'discord_webhook', variable: 'DISCORD_WEBHOOK')]) {
            sh """
              set -eu
              # build a tiny embed payload (no jq needed)
              TITLE=\$(printf %s '${title}' | sed 's/\"/\\\\\"/g')
              URL="\${BUILD_URL}"
              printf '{"embeds":[{"title":"%s","url":"%s","color":%s}]}' \
                     "\$TITLE" "\$URL" "${color}" > /tmp/payload.json

              curl -sS -H 'Content-Type: application/json' \
                   --data @/tmp/payload.json "\$DISCORD_WEBHOOK" >/dev/null
            """
          }
        }
      }
    }
  }
}
