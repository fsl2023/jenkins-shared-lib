def call(Map args =[:]) {
    def serverId = args.serverId ?: error('Nexus server id required')
    def credentialsId = args.credentialsId ?: error('credentialsId is required')
    def repository = args.repo ?: error('Nexus repo name is required')

    configFileProvider([configFile(fileId: serverId, variable: 'MAVEN_SETTINGS')]) {
            withCredentials([usernamePassword(credentialsId: credentialsId, 
                                              usernameVariable: 'NEXUS_USER', 
                                              passwordVariable: 'NEXUS_PASS')]) {
                sh "mvn deploy -s $MAVEN_SETTINGS -Dnexus.repo=${repository}"
    }
    }
}
