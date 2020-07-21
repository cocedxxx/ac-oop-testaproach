package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class StudentMyGrades extends SideMenu {

    @FindBy(xpath = "//*[@class='info']")
    private WebElement userInfo;


    private WebElement gradeStatus(String myAssignmentName){
        return getDriver().findElement(By.xpath("//*[contains(text(),'" + myAssignmentName + "')]/../*[@class='result']"));
    }

    private WebElement buttonDetails(String myAssignmentName){
        return getDriver().findElement(By.xpath("//*[contains(text(),'" + myAssignmentName + "')]/..//button"));
    }

    private WebElement gradeScore(String myAssignmentName){
        return getDriver().findElement(By.xpath("//*[contains(text(),'" + myAssignmentName + "')]/../*[contains(text(),'of')]"));
    }

}
