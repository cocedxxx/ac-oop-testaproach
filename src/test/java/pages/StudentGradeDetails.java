package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentGradeDetails extends SideMenu {

    @FindBy(xpath = "//*[text()='Close']/..")
    private WebElement buttonClose;
}
