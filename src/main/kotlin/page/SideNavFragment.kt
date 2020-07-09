package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

/**
 * Side navigation bar fragment.
 *
 * This page fragment should be used with other pages that include it - e.g. Dashboard, Sales, Account, etc.
 * It realizes the navigation between pages once the user is logged in.
 * @param driver WebDriver being used to drive the page
 */
class SideNavFragment(private val driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//*[@data-selector='SIDENAV.NAV_ITEMS.SALES']")
    private var salesButton: WebElement? = null

    @FindBy(xpath = "//*[@data-selector='SIDENAV.NAV_ITEMS.REFERRALS']")
    private var referralButton: WebElement? = null

    /**
     * Navigates to the Sales page.
     * Firstly, it ensures the navigation bar is active by waiting for the last element that appears on it (referral button) to be clickable.
     * @return SalesPage object
     */
    fun goToSalesPage(): SalesPage {
        WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(referralButton))
        salesButton?.click()
        return SalesPage(driver)
    }
}