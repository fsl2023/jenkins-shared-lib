def call(Map args = [:]) {
    def serverId     = args.serverId ?: error('settings.xml fileId is required')
    def credentialsId = args.credentialsId ?: error('Nexus credentialsId is required')

    configFileProvider([configFile(fileId: serverId, variable: 'MAVEN_SETTINGS')]) {
        withCredentials([usernamePassword(credentialsId: credentialsId,
                                          usernameVariable: 'NEXUS_USER',
                                          passwordVariable: 'NEXUS_PASS')]) {
            sh "mvn clean deploy -s $MAVEN_SETTINGS"
        }
    }
}
