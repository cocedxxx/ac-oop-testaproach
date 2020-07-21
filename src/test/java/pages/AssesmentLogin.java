package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssesmentLogin extends Page {
    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//mat-error[@id='mat-error-0']")
    private WebElement errMessageForEmailField;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//mat-error[@id='mat-error-1']")
    private WebElement errMessageForPasswordField;

    @FindBy(xpath = "//span[contains(text(),'Sign In')]")
    private WebElement buttonSingIn;

    @FindBy(xpath = "//a[contains(text(),'I forgot my password')]")
    private WebElement linkForgotPassword;

    @FindBy(xpath = "//span[contains(text(),'Register Now')]")
    private WebElement buttonRegisteNow;


}
