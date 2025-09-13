def call(Map args = [:]) {
    def context = args.context ?: 'minikube'
    def manifest = args.manifest ?: error('k8s manifest file is required')

    sh "kubectl apply --context=${context} -f ${manifest}"
}
