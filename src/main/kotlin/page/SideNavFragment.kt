package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class SideNavFragment(private val driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//*[@data-selector='SIDENAV.NAV_ITEMS.SALES']")
    private var salesButton: WebElement? = null

    fun goToSalesPage(): SalesPage {
        WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(salesButton))
        salesButton?.click()
        return SalesPage(driver)
    }
}