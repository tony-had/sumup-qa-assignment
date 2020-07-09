package base

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeTest
import util.Util
import java.net.URI
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


abstract class TestBase {
    lateinit var driver: WebDriver
        private set

    @BeforeMethod
    fun setUpMethod() {
        System.setProperty(Util.getProperties("driverName"),
                Util.getProperties("driverPath") + Util.getProperties("driverExe"))
        val timeStamp = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Date())
        System.setProperty("webdriver.chrome.logfile", "chromelog_${timeStamp}.log")
        driver = ChromeDriver()
        driver.manage()?.timeouts()?.implicitlyWait(5, TimeUnit.SECONDS)
        driver.manage()?.window()?.maximize()
        driver.get(URI(Util.getProperties("baseUrl")).toString())
    }

    @AfterMethod
    fun tearDownMethod() {
        driver.quit()
    }
}