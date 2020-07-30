package pages;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;
import static support.TestContext.upperCaseAllFirstCharacter;

public class Registration extends Page {

// -- FIELDS --
    public Registration (){
        url = "http://ask-qa.portnov.com/#/registration";
    }

    @FindBy(xpath = "//span[contains(text(),'Register Me')]")
    private WebElement buttonRegister;

    @FindBy(xpath = "//span[contains(text(),'Back to Login')]")
    private WebElement buttonBackLoging;

    @FindBy(xpath = "//mat-error[@role='alert']")
    private WebElement errMessage;

    private WebElement regisFields(String nameOfField) {
        return getDriver().findElement(By.xpath("//*[contains(@placeholder,'" + nameOfField + "')]"));
    }

    //mat-error[@role='alert']
// -- METHODS --

    public void fillRegFields(String data, String nameOfField){
        String regFields = upperCaseAllFirstCharacter(nameOfField);
        sendKeysSafe(regisFields(regFields), data);
    }

    public void clickRegisterButton(){
        buttonRegister.click();
    }

    public String getErrMessage(){
        return errMessage.getText();
    }

}
