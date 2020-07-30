package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;
import static support.TestContext.upperCaseAllFirstCharacter;

public class SideMenu extends Page{

    @FindBy(xpath = "//*[@class='info']")
    private WebElement userInfo;

    private WebElement sideMenuLink(String menuOption){
        return getDriver().findElement(By.xpath("//*[text()='" + upperCaseAllFirstCharacter(menuOption) + "']/../../"));
    }

    public WebElement userInformation(){
        return userInfo;
    }





}
