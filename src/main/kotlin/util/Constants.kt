package util

object Constants {
    const val baseUrl = "https://sumup.com/"

    private const val browserstackUsername = "tonyhadjiivanov1"
    private const val browserstackAutomateKey = "iqG6MeAWtqqRvnS3TFgR"
    const val browserstackDriverUrl = "https://${Constants.browserstackUsername}:${Constants.browserstackAutomateKey}@hub-cloud.browserstack.com/wd/hub"

    const val seleniumVersion = "3.141.59"
    const val testResolution = "1920x1080"
}