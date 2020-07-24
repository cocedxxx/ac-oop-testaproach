package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeacherHome extends SideMenu {

    @FindBy(xpath = "//*[contains(text(),'Go To Submissions')]/..")
    private WebElement buttonGoToSubmissions;

    @FindBy(xpath = "//*[contains(text(),'Go To Assignments')]/..")
    private WebElement buttonGoToAssignments;

    @FindBy(xpath = "//*[contains(text(),'Go To Users Management')]/..")
    private WebElement buttonGoToUserManagement;



}
