package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class SideMenu {
    @FindBy(xpath = "//*[@class='info']")
    private WebElement userInfo;

    private WebElement sideMenuLink(String menuOption){
        return getDriver().findElement(By.xpath("//*[text()='" + menuOption + "']/../../"));
    }

}
