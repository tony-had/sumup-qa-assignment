package base

import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeTest
import org.testng.annotations.Parameters
import util.Util
import java.net.URI
import java.net.URL


abstract class TestBase() {
    lateinit var driver: WebDriver
        private set

    private lateinit var driverUrl: String
    private lateinit var caps: DesiredCapabilities

    @BeforeTest
    @Parameters("os", "os_version", "browser", "browser_version")
    fun setUpClass(os: String, os_version: String, browser: String, browser_version: String) {
        // BrowserStack Setup
        val username = "tonyhadjiivanov1"
        val automateKey = "iqG6MeAWtqqRvnS3TFgR"
        driverUrl = "https://$username:$automateKey@hub-cloud.browserstack.com/wd/hub"
        caps = DesiredCapabilities()
        caps.setCapability("project", "SumUp QA Assignment")
        caps.setCapability("build", "Build 1")
        val testClass = this::class.java.name.split(".").last()
        val infoName = "$testClass - $os $os_version - $browser $browser_version"
        caps.setCapability("name", infoName)
        caps.setCapability("seleniumVersion", "3.141.59")
        caps.setCapability("resolution", "1920x1080")

        caps.setCapability("os", os)
        caps.setCapability("os_version", os_version)

        caps.setCapability("browser", browser)
        caps.setCapability("browser_version", browser_version)
    }

    @BeforeMethod
    fun setUpMethod() {
        driver = RemoteWebDriver(URL(driverUrl), caps)
        driver.manage().window().maximize()

        driver.get(URI(Util.getProperties("baseUrl")).toString())
    }

    @AfterMethod
    fun tearDownMethod() {
        driver.quit()
    }
}