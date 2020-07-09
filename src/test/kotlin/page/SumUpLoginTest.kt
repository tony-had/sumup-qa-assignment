package page

import base.TestBase
import org.testng.annotations.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SumUpLoginTest : TestBase() {

    @Test
    fun loginWithIncompletePersonalDetails() {
        val geoModalDialog = GeoModalDialog(driver)
        val homePage = geoModalDialog.proceedToLocalWebsite()
        val loginPage = homePage.goToLoginPage()
        val accountPage = loginPage.login("tony.hadjiivanov@gmail.com", "%9aA&llTnQ\$t7hn9")
        val salesPage = accountPage.goToSalesPage()
        assertTrue(salesPage.transactionSearchBoxIsDisplayed(), "The sales page was not opened.")
        assertFalse(salesPage.transactionListIsDisplayed(), "An incomplete account can not have a transaction history.")
    }
}