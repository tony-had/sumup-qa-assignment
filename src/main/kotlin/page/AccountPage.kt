package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

/**
 * Account page.
 *
 * The page where a user's account, personal, bank & payout details can be modified
 * @param driver WebDriver being used to drive the page
 * @param sideNavFragment SideNavFragment object to be used for navigating to other pages
 */
class AccountPage(private val driver: WebDriver,
                  private val sideNavFragment: SideNavFragment = SideNavFragment(driver)) : BasePage(driver) {

    @FindBy(xpath = "//*[@data-selector='SUBMIT_BUTTON']")
    private val payoutDetailsSubmitButton: WebElement? = null

    /**
     * Navigates to the Sales page using the side navigation bar.
     * Before navigation, it ensures the page has finished loading using the Submit button of the Personal Details section.
     * @return SalesPage object
     */
    // TODO: find a more universal way to ensure this page has loaded
    fun goToSalesPage(): SalesPage {
        WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(payoutDetailsSubmitButton))
        return sideNavFragment.goToSalesPage()
    }
}