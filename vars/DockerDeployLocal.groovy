def call(Map args = [:]) {
    def image = args.image ?: error('image name is required')
    def name = args.name ?: error('container name is required')
    def HostPort = args.HostPort ?: error('port number required')
    def containerPort = args.containerPort ?: error('port number required')

    sh """ docker stop ${name} || true
           docker rm ${name} || true
           docker run -d -p ${HostPort}:${containerPort} --name ${name} ${image}
       """   
}
