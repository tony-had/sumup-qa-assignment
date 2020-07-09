package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class SumUpHomePage(private val driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//*[@data-selector='login@action-area']")
    private val loginButton: WebElement? = null

    fun goToLoginPage(): LoginPage {
        WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(loginButton))
        loginButton?.click()
        return LoginPage(driver)
    }
}