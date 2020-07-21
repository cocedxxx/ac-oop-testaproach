package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssesmentRegistration extends Page {
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement fieldFname;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement fieldLname;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//input[@placeholder='Group Code']")
    private WebElement fieldGroup;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    private WebElement fieldConfPassword;

    @FindBy(xpath = "//span[contains(text(),'Register Me')]")
    private WebElement buttonRegister;

    @FindBy(xpath = "//span[contains(text(),'Back to Login')]")
    private WebElement buttonBackLoging;


}
