package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssesmentHome {
    @FindBy(xpath = "//*[contains(text(),'Home')]/../..")
    private WebElement linkHome;

    @FindBy(xpath = "//*[contains(text(),'Log Out')]/../..")
    private WebElement linkLogOut;

    @FindBy(xpath = "//*[contains(text(),'Settings')]/../..")
    private WebElement linkSettings;
}
