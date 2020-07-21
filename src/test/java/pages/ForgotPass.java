package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPass extends Login {
    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//span[contains(text(),'Request Password Reset')]")
    private WebElement buttonRequestPassReset;

    @FindBy(xpath = "//span[contains(text(),'Back to Login')]")
    private WebElement buttonBackLogin;


}
