package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class SalesPage(private val driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//*[@data-selector='TRANSACTIONS_HISTORY.TRANSACTION_LIST']")
    private val transactionList: WebElement? = null

    @FindBy(xpath = "//*[@data-selector='TRANSACTIONS_FILTERS.SEARCH']")
    private val transactionSearchBox: WebElement? = null

    fun transactionSearchBoxIsDisplayed(): Boolean {
        try {
            transactionSearchBox?.isDisplayed?.let { return it } ?: return false
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            return false
        }
    }

    fun transactionListIsDisplayed(): Boolean {
        try {
            transactionList?.isDisplayed?.let { return it } ?: return false
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            return false
        }
    }
}