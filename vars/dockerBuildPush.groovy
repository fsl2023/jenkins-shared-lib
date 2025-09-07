def call(Map args = [:] ) {
    def imageName = args.imageName ?: error("imageName is required")
    def tag       = args.tag ?: 'latest'
    def context   = args.context ?: '.'
    def credentialsId = args.credentialsId ?: error("credentialsId is required")

    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh "docker build -t ${imageName}:${tag} ${context}"
        sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
        sh "docker push ${imageName}:${tag}"
    }
}
