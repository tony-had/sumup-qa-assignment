package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class SalesPage(private val driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//*[@data-selector='TRANSACTIONS_HISTORY.TRANSACTION_LIST']")
    private val transactionList: WebElement? = null

    @FindBy(xpath = "//*[@data-selector='CALENDAR_BUTTON']")
    private val calendarButton: WebElement? = null

    fun transactionListIsDisplayed(): Boolean {
        WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(calendarButton))
        try {
            transactionList?.isDisplayed?.let { return it } ?: return false
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            return false
        }
    }
}