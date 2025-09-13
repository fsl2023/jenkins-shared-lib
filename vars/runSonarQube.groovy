def call(Map args = [:]) {
    def server = args.server ?: error('sonarqube server name is required')
    def projectKey = args.projectKey ?: error('project key is required')

    withSonarQubeEnv(server) {
        sh " mvn sonar:sonar -Dsonar.projectKey=${projectKey}"
    }
}
