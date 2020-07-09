package base

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory

/**
 * Page object base class.
 *
 * Every page object class deriving from this base class initializes its elements on construction
 * @param driver WebDriver being used to drive the page
 */
abstract class BasePage(driver: WebDriver) {

    /**
     * Initializes all elements of the derived class using the AjaxElementLocatorFactory.
     */
    init {
        PageFactory.initElements(AjaxElementLocatorFactory(driver, 5), this)
    }
}