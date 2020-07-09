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

/**
 * Test base class.
 *
 * This test base class implements a set up and tear down function used by all tests that derive from it.
 */
abstract class TestBase() {
    lateinit var driver: WebDriver
        private set

    private lateinit var driverUrl: String
    private lateinit var caps: DesiredCapabilities

    /**
     * Parametrized test class set up method.
     * Extra care must be taken to pass strings that Browserstack will recognize
     * @param os target operating system
     * @param os_version target operating system's version
     * @param browser target browser
     * @param browser_version target browser version
     */
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

    /**
     * Set up the remote driver before each test method and open the page.
     */
    @BeforeMethod
    fun setUpMethod() {
        driver = RemoteWebDriver(URL(Constants.browserstackDriverUrl), caps)
        driver.manage().window().maximize()

        driver.get(Constants.baseUrl)
    }

    /**
     * Quit the driver after each test method.
     */
    @AfterMethod
    fun tearDownMethod() {
        driver.quit()
    }
}