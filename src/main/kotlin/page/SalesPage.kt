package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

/**
 * Sales page.
 *
 * The page where a user can see a list of their transactions.
 * @param driver WebDriver being used to drive the page
 */
class SalesPage(private val driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//*[@data-selector='TRANSACTIONS_HISTORY.TRANSACTION_LIST']")
    private val transactionList: WebElement? = null

    @FindBy(xpath = "//*[@data-selector='TRANSACTIONS_FILTERS.SEARCH']")
    private val transactionSearchBox: WebElement? = null

    /**
     * Tells whether the transaction search box is displayed.
     * @return true if the search box is displayed, false if not
     */
    fun transactionSearchBoxIsDisplayed(): Boolean {
        try {
            transactionSearchBox?.isDisplayed?.let { return it } ?: return false
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            return false
        }
    }

    /**
     * Tells whether the transaction list is displayed.
     * @return true if the list is displayed, false if not
     */
    fun transactionListIsDisplayed(): Boolean {
        try {
            transactionList?.isDisplayed?.let { return it } ?: return false
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            return false
        }
    }
}