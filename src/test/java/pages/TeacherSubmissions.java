package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class TeacherSubmissions extends SideMenu {

    @FindBy(xpath = "//div[text()='For Grade']/..//div")
    private WebElement tabForGrade;

    @FindBy(xpath = "//div[text()='Automatically Graded']/..//div")
    private WebElement tabAutoGraded;

    @FindBy(xpath = "//div[text()='Reviewed']/..//div")
    private WebElement tabReviewed;

    private WebElement buttonGrade(String studentName, String  quizName){
        return getDriver().findElement(By.xpath("//*[text()='"+ studentName +"']/..//*[text()='"+ quizName +"']/..//button"));
    }

    private WebElement autoScore(String studentName, String  quizName){
        return getDriver().findElement(By.xpath("//*[text()='"+ studentName +"']/..//*[text()='"+ quizName +"']/..//*[contains(text(),'of')"));
    }


}
