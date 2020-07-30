package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;
import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;
import static support.TestContext.*;

public abstract class Page {
    protected String url;
    protected String title;

    @FindBy(xpath = "//span[contains(text(),'Log Out')]")
    private WebElement buttonLogOut;

    @FindBy(xpath = "//span[contains(text(),'No, Thanks')]")
    private WebElement buttonNoThanks;

    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open() {
        getDriver().get(url);
    }

    public boolean areErrorsPresent() {
        LogEntries logEntries = getDriver().manage().logs().get("browser");
        for (LogEntry logEntry:logEntries ){
            if(logEntry.getLevel().equals(Level.SEVERE)){
                System.err.println(logEntry);
                return true;
            }
        }
        return false;
    }

    public void waitingToBeVisible(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void waitingToBeClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickSafe(WebElement element) {
        waitingToBeClickable(element);
        try {
            element.click();
        }catch (ElementClickInterceptedException e) {
            getExecuter().executeScript("arguments[0].click()", element);
        }
    }

    public void sendKeysSafe(WebElement into, String value){
        waitingToBeVisible(into);
        String currentValue = into.getAttribute("value");
        if(!currentValue.isEmpty()){
            into.clear();
        }
        into.sendKeys(value);
    }


}
