package support;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber/report.json"},
        features = "scr/test/resources/features",
        glue = {"definition", "support"},
        tags = {"@predefined"}
)

public class TestRunner {
    @BeforeClass
    public static void setup(){
        System.out.println("Before");
    }

    @AfterClass
    public static void teardown(){
        System.out.println("After");
    }
}
