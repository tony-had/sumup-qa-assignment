package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

/**
 * Login page.
 *
 * The page where a user can enter their credentials and log in.
 * @param driver WebDriver being used to drive the page
 */
class LoginPage(private val driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//*[@data-selector='LOGIN.EMAIL_INPUT']")
    private val emailField: WebElement? = null

    @FindBy(xpath = "//*[@data-selector='LOGIN.PASSWORD_INPUT']")
    private val passwordField: WebElement? = null

    @FindBy(xpath = "//*[@data-selector='LOGIN.LOGIN_BUTTON']")
    private val loginButton: WebElement? = null

    /**
     * Logs in using provided credentials.
     * Before that, it waits for the page to load using the login button.
     * @param email email address to log in with
     * @param password password to log in with
     * @return AccountPage object
     */
    fun login(email: String, password: String): AccountPage {
        WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(loginButton))
        emailField?.sendKeys(email)
        passwordField?.sendKeys(password)
        loginButton?.click()
        return AccountPage(driver)
    }
}