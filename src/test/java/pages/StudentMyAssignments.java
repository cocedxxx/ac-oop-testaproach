package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static support.TestContext.getDriver;

public class StudentMyAssignments extends SideMenu {

    private WebElement buttonGoToAssessment(String myAssignmentName){
        return getDriver().findElement(By.xpath("//td[contains(text(),'" + myAssignmentName + "')]/..//button"));
    }
}
