package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentHome extends SideMenu {

    @FindBy(xpath = "//span[contains(text(),'Go To My Assignments')]/..")
    private WebElement buttonGoToMyAssignments;

    @FindBy(xpath = "//span[contains(text(),'Go To My Grades')]/..")
    private WebElement buttonGoToMyGrades;

}
