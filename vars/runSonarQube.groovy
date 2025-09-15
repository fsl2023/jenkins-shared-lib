def call(Map args = [:]) {
    def server = args.server ?: error('sonarqube server name is required')
    def projectKey = args.projectKey ?: error('project key is required')
    def coverageReport = args.coverageReport ?: 'target/site/jacoco/jacoco.xml'

    withSonarQubeEnv(server) {
        sh " mvn sonar:sonar -Dsonar.projectKey=${projectKey} -Dsonar.coverage.jacoco.xmlReportPaths=${coverageReport}"
    }
}
