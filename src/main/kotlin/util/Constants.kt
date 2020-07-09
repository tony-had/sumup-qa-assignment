package util

/**
 * Constants object.
 *
 * This object contains constants used across the project.
 */
object Constants {
    // SumUp base URL
    const val baseUrl = "https://sumup.com/"

    // Browserstack authorization and driver strings
    private const val browserstackUsername = "tonyhadjiivanov1"
    private const val browserstackAutomateKey = "iqG6MeAWtqqRvnS3TFgR"
    const val browserstackDriverUrl = "https://${Constants.browserstackUsername}:${Constants.browserstackAutomateKey}@hub-cloud.browserstack.com/wd/hub"

    // Extra Browserstack capabilities
    const val seleniumVersion = "3.141.59"
    const val testResolution = "1920x1080"

    // Test account details
    const val testAccountEmail = "tony.hadjiivanov@gmail.com"
    const val testAccountPassword = "%9aA&llTnQ\$t7hn9"
}