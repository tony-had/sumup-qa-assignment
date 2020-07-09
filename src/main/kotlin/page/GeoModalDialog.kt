package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class GeoModalDialog(private val driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//*[@data-selector='button_primary@geo_modal']")
    private val proceedToLocalWebsiteButton: WebElement? = null

    fun proceedToLocalWebsite(): SumUpHomePage {
        proceedToLocalWebsiteButton?.click()
        return SumUpHomePage(driver)
    }
}