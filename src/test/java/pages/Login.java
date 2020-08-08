package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class Login extends Page {

    // PROPERTIES

    public Login (){
        url = "http://ask-qa.portnov.com/#/login";
    }

    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//*[@placeholder='Email *']/../../..//*[@role='alert']")
    private WebElement errMessageForEmailField;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//*[@placeholder='Password *']/../../..//*[@role='alert']")
    private WebElement errMessageForPasswordField;

    @FindBy(xpath = "//span[contains(text(),'Sign In')]")
    private WebElement buttonSingIn;

    @FindBy(xpath = "//a[contains(text(),'I forgot my password')]")
    private WebElement linkForgotPassword;

    @FindBy(xpath = "//span[contains(text(),'Register Now')]")
    private WebElement buttonRegisteNow;

    @FindBy(xpath = "//snack-bar-container[@role='alert']/.//*[contains(text(),'Authentication failed')]")
    private WebElement barAuthenticatioFailed;

    //METHODS

    public Login enterEmail(String mail){
        sendKeysSafe(fieldEmail, mail);
        return new Login();
    }

    public Login enterPass(String pass){
        sendKeysSafe(fieldPassword, pass);
        return new Login();
    }

    public Login signIn(){
        clickSafe(buttonSingIn);
        return new Login();
    }
    public boolean autMessageIsPresent(){
        getWait().until(driver -> barAuthenticatioFailed.isDisplayed());
        return true;
    }
    public boolean passwordMaskIsPresent(){
        return fieldPassword.getAttribute("type").contains("password");
    }

    public String errMessageEmail(){
        getWait().until(driver -> errMessageForEmailField.isDisplayed());
        return errMessageForEmailField.getText();
    }
    public String errMessagePass(){
        getWait().until(driver -> errMessageForPasswordField.isDisplayed());
        return errMessageForPasswordField.getText();
    }
    public void loginAs(String role){
        enterEmail(role)
                .enterPass(role)
                .signIn();
    }


}
