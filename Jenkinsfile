node {
    stage('SCM') {
        git 'https://github.com/SoftwareProcessHomework/SSHProject.git'
    }
    stage('QA') {
		sh 'sonar-scanner'
	}
    stage('build') {
        def mvnHome = tool 'M3'
        sh "${mvnHome}/bin/mvn -B clean package"
    }
    stage('deploy') {
	sh "who am i"
        sh "sudo docker stop my || true"
        sh "sudo docker rm my || true"
        sh "sudo docker run --name my -p 11111:8080 -d tomcat"
        sh "sudo docker cp target/SSHProject.war my:/usr/local/tomcat/webapps"
    }
    stage('results') {
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }
}
