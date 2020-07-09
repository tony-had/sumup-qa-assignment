package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class SumUpHomePage(private val driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//*[@data-selector='login@action-area']")
    private val loginButton: WebElement? = null

    fun goToLoginPage(): LoginPage {
        loginButton?.click()
        return LoginPage(driver)
    }
}