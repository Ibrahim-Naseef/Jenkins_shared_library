def call() {
  withCredentials([string(credentialsId: 'Nvidia', variable: 'NVD_KEY')]) {
    dependencyCheck(
      odcInstallation: 'OWASP',
      additionalArguments: "--scan ./ --nvdApiKey ${NVD_KEY}"
    )
  }
  dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
