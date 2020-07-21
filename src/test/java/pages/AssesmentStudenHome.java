package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssesmentStudenHome extends AssesmentHome{

    @FindBy(xpath = "//*[contains(text(),'My Assignments')]/../..")
    private WebElement linkMyAssignents;

    @FindBy(xpath = "//*[contains(text(),'My Grades')]/../..")
    private WebElement linkMyGrades;

}
