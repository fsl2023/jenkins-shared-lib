def call(Map args = [:]) {
    def cmd = args.cmd ?: 'mvn test'
    def reportPath = args.reportPath ?: 'target/surefire-reports/*.xml'

    sh cmd
    junit reportPath 
}
