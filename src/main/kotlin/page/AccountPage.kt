package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class AccountPage(private val driver: WebDriver,
                  private val sideNavFragment: SideNavFragment = SideNavFragment(driver)) : BasePage(driver) {

    @FindBy(xpath = "//*[@data-selector='PERSONAL_DETAILS.SUBMIT']")
    private val personalDetailsSubmitButton: WebElement? = null

    fun goToSalesPage(): SalesPage {
        WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(personalDetailsSubmitButton))
        return sideNavFragment.goToSalesPage()
    }
}