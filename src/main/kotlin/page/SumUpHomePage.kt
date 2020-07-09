package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

/**
 * SumUp home page.
 *
 * SumUp's main page.
 * @param driver WebDriver being used to drive the page
 */
class SumUpHomePage(private val driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//*[@data-selector='login@action-area']")
    private val loginButton: WebElement? = null

    /**
     * Goes to the login page by clicking the login button.
     * Firstly, it ensures the login button is clickable.
     * @return LoginPage object
     */
    fun goToLoginPage(): LoginPage {
        WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(loginButton))
        loginButton?.click()
        return LoginPage(driver)
    }
}