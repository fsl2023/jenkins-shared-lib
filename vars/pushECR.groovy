def call(Map args = [:]) {
    def accountId = args.accountId ?: error("aws account Id is required")
    def region = args.region ?: error("region required")
    def repo = args.repo ?: error("ECR repo name is required")
    def image = args.image ?: error("image name is required")
    def tag = args.tag ?: error("tag is required")
    def credentials = args.credentials ?: error("credentials is requried")

    withAWS(credentials: credentials, region: region) {
        sh """
            aws ecr get-login-password --region ${region} \
                | docker login --username AWS --password-stdin ${accountId}.dkr.ecr.${region}.amazonaws.com
              docker tag ${image}:${tag} ${accountId}.dkr.ecr.${region}.amazonaws.com/${repo}:${tag}
              docker push ${accountId}.dkr.ecr.${region}.amazonaws.com/${repo}:${tag}
           """    
    }
}
