def call(Map args = [:]) {
    def IMAGE_NAME = args.IMAGE_NAME ?: error('image name is required')
    def CONTAINER_NAME = args.CONTAINER_NAME ?: error('container name is required')
    def hostPort = args.hostPort ?: error('port number required')
    def containerPort = args.containerPort ?: error('port number required')

    sh """ docker stop ${CONTAINER_NAME} || true
           docker rm ${CONTAINER_NAME} || true
           docker run -d -p ${HostPort}:${containerPort} --name ${CONTAINER_NAME} ${IMAGE_NAME}
       """   
}
