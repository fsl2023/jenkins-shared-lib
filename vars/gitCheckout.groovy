def call(Map args = [:]) {
 def url =   args.url ?: error("git repo url is required")
 def branch = args.branch :? main
 def credentialsId = args.credentialsId :? error("credentials Id is required")

 git url : url, branch: branch, credentialsId: credentialsId
}
