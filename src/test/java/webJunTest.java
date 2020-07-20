import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import static org.assertj.core.api.Assertions.assertThat;

public class webJunTest {

    private WebDriver driver; //declare outside
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup(); //help to start chrome and set up
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); //if true - shut all log from driver and what happen
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @Test
    public void verTitle(){
        String actTitle = driver.getTitle();
        assertThat(actTitle).isEqualTo("Google");
    }

    @Test
    public void testFields(){
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hahahahha");
        String actValue = driver.findElement(By.xpath("//input[@name='q']")).getAttribute("value");
        assertThat(actValue).isEqualTo("hahahahha");
    }

    @After
    public void after(){
        driver.quit();
    }
}
