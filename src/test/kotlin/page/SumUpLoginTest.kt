package page

import base.TestBase
import org.testng.annotations.Test
import util.Constants
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Login tests.
 */
class SumUpLoginTest : TestBase() {

    /**
     * Log in with an account that is not yet completed.
     * Verify no transactions are displayed on the Sales page.
     * 
     * 1. Open the SumUp website.
     * 2. Proceed to the local website from the modal dialog.
     * 3. Go to the login page.
     * 4. Login with an incomplete account.
     * 5. Go to the Sales page.
     * 6. Verify the Sales page is opened and look for a transaction list.
     */
    @Test
    fun loginWithIncompletePersonalDetails() {
        val geoModalDialog = GeoModalDialog(driver)
        val homePage = geoModalDialog.proceedToLocalWebsite()
        val loginPage = homePage.goToLoginPage()
        val accountPage = loginPage.login(Constants.testAccountEmail, Constants.testAccountPassword)
        val salesPage = accountPage.goToSalesPage()
        assertTrue(salesPage.transactionSearchBoxIsDisplayed(), "The sales page was not opened.")
        assertFalse(salesPage.transactionListIsDisplayed(), "An incomplete account can not have a transaction history.")
    }
}