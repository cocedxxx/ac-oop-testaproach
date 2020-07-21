package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentSettings extends SideMenu {

    @FindBy(xpath = "//*[contains(text(),'Change Your Name')]")
    private WebElement buttonChangeName;

    @FindBy(xpath = "//*[contains(text(),'Change Your Password')]")
    private WebElement buttonChangePassword;

    @FindBy(xpath = "//input[@placeholder='New name']")
    private WebElement fieldNewName;

    @FindBy(xpath = "//*[text()='Change']/..")
    private WebElement buttonChange;

    @FindBy(xpath = "//*[text()='Cancel']/..")
    private WebElement buttonCancel;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//input[@placeholder='Password']/../../..//mat-error")
    private WebElement errFieldPassword;

    @FindBy(xpath = "//input[@placeholder='New Password']")
    private WebElement fieldNewPassword;

    @FindBy(xpath = "//input[@placeholder='New Password']/../../..//mat-error")
    private WebElement errFieldNewPassword;

    @FindBy(xpath = "//input[@placeholder='Confirm New Password']")
    private WebElement fieldConfNewPassword;

    @FindBy(xpath = "//input[@placeholder='Confirm New Password']/../../..//mat-error")
    private WebElement errFieldConfNewPassword;

}
