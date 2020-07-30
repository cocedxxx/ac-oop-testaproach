package pages;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class Registration extends Page {

    public Registration (){
        url = "http://ask-qa.portnov.com/#/registration";
    }

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
//OR

//    @When("I type {string} {string}")
//    public void iType(String arg0, String arg1) {
//        char[] array = arg0.toCharArray();
//        array[0] = Character.toUpperCase(array[0]);
//        for (int i = 1; i < array.length; i++) {
//            if (Character.isWhitespace(array[i - 1])) {
//                array[i] = Character.toUpperCase(array[i]);
//            }
//        }
//        arg0 = new String(array);
//
//        getDriver().findElement(By.xpath("//*[contains(@placeholder,'" + arg0 + "')]")).sendKeys(arg1);
//    }
//    @And("I type {string} {string} on registration page")
//    public void iTypeOnRegistrationPage(String arg0, String arg1) {
//        iType(arg0,arg1);
//    }

}
