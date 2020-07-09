package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class LoginPage(private val driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//*[@data-selector='LOGIN.EMAIL_INPUT']")
    private val emailField: WebElement? = null

    @FindBy(xpath = "//*[@data-selector='LOGIN.PASSWORD_INPUT']")
    private val passwordField: WebElement? = null

    @FindBy(xpath = "//*[@data-selector='LOGIN.LOGIN_BUTTON']")
    private val loginButton: WebElement? = null

    fun login(email: String, password: String): AccountPage {
        WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(loginButton))
        emailField?.sendKeys(email)
        passwordField?.sendKeys(password)
        loginButton?.click()
        return AccountPage(driver)
    }
}