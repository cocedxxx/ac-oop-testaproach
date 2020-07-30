package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getWait;

public class RegistrationConfirmation extends Registration{

    @FindBy(xpath = "//*[contains(text(),'You have been Registered.')]")
    private WebElement messageConfirmation;

    @FindBy(xpath = "//*[contains(text(),'Back to Login')]/..")
    private WebElement buttonBackToLogin;

    public void clickBackToLogin(){
        buttonBackToLogin.click();
    }

    public Boolean isRegisConfirm(){
        getWait().until(driver -> messageConfirmation.isDisplayed());
        return true;
    }



}
