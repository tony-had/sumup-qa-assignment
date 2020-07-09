package base

import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeTest
import org.testng.annotations.Parameters
import util.Constants
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
        caps = DesiredCapabilities()
        caps.setCapability("project", "SumUp QA Assignment")
        caps.setCapability("build", "Build 1")
        val testClass = this::class.java.name.split(".").last()
        val infoName = "$testClass - $os $os_version - $browser $browser_version"
        caps.setCapability("name", infoName)
        caps.setCapability("seleniumVersion", Constants.seleniumVersion)
        caps.setCapability("resolution", Constants.testResolution)

        caps.setCapability("os", os)
        caps.setCapability("os_version", os_version)

        caps.setCapability("browser", browser)
        caps.setCapability("browser_version", browser_version)
    }

    @BeforeMethod
    fun setUpMethod() {
        driver = RemoteWebDriver(URL(Constants.browserstackDriverUrl), caps)
        driver.manage().window().maximize()

        driver.get(Constants.baseUrl)
    }

    @AfterMethod
    fun tearDownMethod() {
        driver.quit()
    }
}