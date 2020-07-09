package page

import base.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

/**
 * Geo modal dialog.
 *
 * This dialog appears when a given local website is accessed from a different locale.
 * @param driver WebDriver being used to drive the page
 */
class GeoModalDialog(private val driver: WebDriver) : BasePage(driver) {

    @FindBy(xpath = "//*[@data-selector='button_primary@geo_modal']")
    private val proceedToLocalWebsiteButton: WebElement? = null

    /**
     * Clicks the primary button on the dialog to proceed to the website local to the locale.
     * Before that, it ensures the modal dialog has fully loaded using the primary button.
     * @return SumUpHomePage object
     */
    fun proceedToLocalWebsite(): SumUpHomePage {
        WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(proceedToLocalWebsiteButton))
        proceedToLocalWebsiteButton?.click()
        return SumUpHomePage(driver)
    }
}