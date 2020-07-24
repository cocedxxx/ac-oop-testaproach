package definitions;

import cucumber.api.java.en.Given;
import pages.QueryDB;

import static org.assertj.core.api.Assertions.assertThat;

public class AssessmentOOPDef {
    @Given("Navigate to {string} page")
    public void navigateToPage(String page) {

        QueryDB doQuery = new QueryDB();

        doQuery.getDBQuery();











    }
}
