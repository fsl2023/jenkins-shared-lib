def call(Map args = [:]) {
    def skipTests = args.skipTests != null ? args.skipTests : true
    def cmd = skipTests ? "mvn clean package -DskipTests" : "mvn clean package"

    sh cmd
}
