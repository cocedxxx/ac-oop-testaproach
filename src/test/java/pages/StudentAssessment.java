package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static support.TestContext.getDriver;

public class StudentAssessment extends SideMenu {

    @FindBy(xpath = "//mat-card")
    private List<WebElement> allQuestions;

    @FindBy(xpath = "//p[contains(text(),'Show-Stopper Question')]")
    private WebElement markShowStoper;

    @FindBy(xpath = "//span[contains(text(),'Submit My Answers')]/..")
    private WebElement buttonSubmitMyAnswer;

    @FindBy(xpath = "//h1[contains(text(),'Success!')]")
    private WebElement modalWindowSuccess;

    @FindBy(xpath = "//span[contains(text(),'Ok')]/..")
    private WebElement buttonOkModalWinSuccess;


    private WebElement textAnswerField(String textQuestion){
        return getDriver().findElement(By.xpath("//*[contains(text(),'" + textQuestion + "')]/..//*[@placeholder='Enter your answer']"));
    }

    private WebElement errorAnswerField(String textQuestion){
        return getDriver().findElement(By.xpath("//*[contains(text(),'" + textQuestion + "')]/..[contains(text(), 'required')]"));
    }

    private WebElement chooseRadiobutton(String textQuestion, String textAnswer){
        return getDriver().findElement(By.xpath("//*[contains(text(),'" + textQuestion + "')]/..//mat-radio-button//div[contains(text(),'" + textAnswer + "')]"));
    }

    private WebElement multiChoiceChooseCheckBox(String textQuestion, String textAnswer){
        return getDriver().findElement(By.xpath("//*[contains(text(),'" + textQuestion + "')]/..//mat-checkbox//span[contains(text(),'" + textAnswer + "')]"));
    }

    private WebElement multiChoiceFieldOther(String textQuestion, String textAnswer){
        return getDriver().findElement(By.xpath("//*[contains(text(),'" + textQuestion + "')]/..//textarea[@placeholder='Other']"));
    }





    public void asnwerTextQuestion(String answerText){

    }
    public void answerSingelQuestion(String answerValue){

    }
    public void answerMultiQuestion(List<String> answers){

    }
}
