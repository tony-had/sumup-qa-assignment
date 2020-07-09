package base

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory

abstract class BasePage(driver: WebDriver) {

    init {
        PageFactory.initElements(AjaxElementLocatorFactory(driver, 5), this)
    }
}