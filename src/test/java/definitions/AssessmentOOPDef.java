package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;
import support.QueryDB;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class AssessmentOOPDef {

    Login pLogin = new Login();
    Registration pRegist = new Registration();
    SideMenu menu = new SideMenu();

    private Map<String, String> data = getData("fieldsTestData");

    @Given("I run script")
    public void iRunScript() {
        QueryDB doQuery = new QueryDB();
        String res = doQuery.getDBQuery("SELECT * FROM users WHERE ID = 7754;", "activationCode");
        System.out.println(res);
    }

    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page){
            case "login":
                pLogin.open();
                break;
            case "registration":
                pRegist.open();
                break;
        }
    }
//LOGIN STEPS
    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String mails) {
        switch (mails){
            case "valid mail":
                String mail = data.get("validTeacherEmail");
                pLogin.enterEmail(mail);
                break;
            case "invalid mail":
                String mailInv = data.get("emailInvalid");
                pLogin.enterEmail(mailInv);
                break;
            case "invalid mail format":
                String mailInvFormat = data.get("emailInvFormat");
                pLogin.enterEmail(mailInvFormat);
                break;
            case "spaces into":
                String mailEmpty = data.get("whiteSpace");
                pLogin.enterEmail(mailEmpty);
                break;
            case "email with leading space":
                String mailLeadSpace = data.get("leadSpace") + data.get("emailInvalid");
                pLogin.enterEmail(mailLeadSpace);
                break;
            case "email with trailing space":
                String mailTrailSpace = data.get("emailInvalid") + " ";
                pLogin.enterEmail(mailTrailSpace);
                break;
            default:
                throw new RuntimeException("incorrect data entered into emailField");
        }
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        switch (password){
            case "valid password":
                String  pass = data.get("validPass");
                pLogin.enterPass(pass);
                break;
            case "invalid":
                String  passInv = data.get("emailInvalid");
                pLogin.enterPass(passInv);
                break;
            case "password with trailing space":
                String  passTrailSpace = data.get("trailSpace");
                pLogin.enterPass(passTrailSpace);
                break;
            case "password with leading space":
                String  passLeadSpace = data.get("leadSpace");
                pLogin.enterPass(passLeadSpace);
                break;
            default:
                throw new RuntimeException("incorrect data entered into passwordField");
        }
    }

    @And("I click Sign in button")
    public void iClickSignInButton() {
        pLogin.signIn();
    }

    @Then("page contain {string}")
    public void pageContain(String message) {
        switch (message){
            case "user Information":
                getWait().until(ExpectedConditions.visibilityOf(menu.userInformation()));
                String userName = data.get("firstName") + " " + data.get("secondName");
                assertThat(menu.userInformation().getText()).contains(userName);
                break;
            case "Should be a valid email address error message":
                assertThat(pLogin.errMessageEmail()).isEqualTo(data.get("emailErrValidAddress"));
                break;
            case "Email field is required message":
                assertThat(pLogin.errMessageEmail()).isEqualTo(data.get("emailErrFieldRequired"));
                break;
            case "Password field is required message":
                assertThat(pLogin.errMessagePass()).isEqualTo(data.get("passwordErrFieldReq"));
                break;
            case "Whitespaces are not allowed error message":
                assertThat(pLogin.errMessagePass()).isEqualTo(data.get("passwordErrSpaceNotAllowed"));
                break;
            case "password mask":
                assertThat(pLogin.passwordMaskIsPresent()).isTrue();
                break;
            case "authentication failed message":
                assertThat(pLogin.autMessageIsPresent()).isTrue();
                break;
            default:
                throw new RuntimeException("provided incorrect message");
        }

    }

//REGISTRATION STEPS

    @When("I type {string} into {string} field")
    public void iTypeIntoField(String name, String fieldName) {
        switch (fieldName){
            case "first name":
                if (name.contains("latin characters")){
                    pRegist.fillRegFields(data.get("latin"), fieldName);
                }else if (name.equalsIgnoreCase("one char")){
                    pRegist.fillRegFields(data.get("latin1"), fieldName);
                }else if (name.equalsIgnoreCase("254 max characters")){
                    pRegist.fillRegFields(data.get("latin254"), fieldName);
                }else if (name.equalsIgnoreCase("whitespaces")){
                    pRegist.fillRegFields(data.get("whiteSpace"), fieldName);
                }else if (name.equalsIgnoreCase("first name")){
                    pRegist.fillRegFields(data.get("rFirstName"), fieldName);
                }
                break;
            case "last name":
                if (name.contains("one char")){
                    pRegist.fillRegFields(data.get("latin1"), fieldName);
                }else if (name.equalsIgnoreCase("last name")){
                    pRegist.fillRegFields(data.get("rLastName"), fieldName);
                }else if (name.equalsIgnoreCase("latin characters")){
                    pRegist.fillRegFields(data.get("latin"), fieldName);
                }else if (name.equalsIgnoreCase("254 max characters")) {
                    pRegist.fillRegFields(data.get("latin254"), fieldName);
                }else if (name.equalsIgnoreCase("255 max characters")) {
                    pRegist.fillRegFields(data.get("latin255"), fieldName);
                }else if (name.equalsIgnoreCase("last name with space")) {
                    pRegist.fillRegFields(data.get("trailSpace"), fieldName);
                }
                break;
            case "email":
                if (name.equalsIgnoreCase("valid mail")) {
                    pRegist.fillRegFields(data.get("rMail"), fieldName);
                }else if (name.equalsIgnoreCase("email max char 64")) {
                    pRegist.fillRegFields(data.get("emailLocalLeft64"), fieldName);
                }else if (name.equalsIgnoreCase("email max char 65")) {
                    pRegist.fillRegFields(data.get("emailLocalLeft65"), fieldName);
                }else if (name.equalsIgnoreCase("email max char 63 for server domain")){
                    pRegist.fillRegFields(data.get("emailServerDomain63"), fieldName);
                }else if (name.equalsIgnoreCase("email max char 64 for server domain")){
                    pRegist.fillRegFields(data.get("emailServerDomain64"), fieldName);
                }else if (name.equalsIgnoreCase("email max char 63 for domain")){
                    pRegist.fillRegFields(data.get("emailDomain63"), fieldName);
                }else if (name.equalsIgnoreCase("email max char 64 for domain")){
                    pRegist.fillRegFields(data.get("emailDomain64"), fieldName);
                }else if (name.equalsIgnoreCase("whitespaces")){
                    pRegist.fillRegFields(data.get("whiteSpace"), fieldName);
                }else if (name.equalsIgnoreCase("email without @")){
                    pRegist.fillRegFields(data.get("emailInvAt"), fieldName);
                }else if (name.equalsIgnoreCase("email without dot")){
                    pRegist.fillRegFields(data.get("emailInvDot"), fieldName);
                }
                break;
            case "group code":
                if (name.equalsIgnoreCase("alphanumeric char")){
                    pRegist.fillRegFields(data.get("alfanumeric"), fieldName);
                }else if (name.equalsIgnoreCase("alphanumeric with special char")){
                    pRegist.fillRegFields(data.get("alfanumericSym"), fieldName);
                }else if (name.equalsIgnoreCase("one char")){
                    pRegist.fillRegFields(data.get("latin1"), fieldName);
                }else if (name.equalsIgnoreCase("max 6 char")){
                    pRegist.fillRegFields(data.get("max6"), fieldName);
                }else if (name.equalsIgnoreCase("max 7 char")){
                    pRegist.fillRegFields(data.get("max7"), fieldName);
                }else if (name.equalsIgnoreCase("whitespaces")){
                    pRegist.fillRegFields(data.get("whiteSpace"), fieldName);
                }else if (name.equalsIgnoreCase("group code")){
                    pRegist.fillRegFields(data.get("rGroup"), fieldName);
                }
                break;
            case "password":
                if (name.equalsIgnoreCase("alphanumeric and special char")){
                    pRegist.fillRegFields(data.get("alfanumericSym"), fieldName);
                }else if (name.equalsIgnoreCase("minimum 5 characters")){
                    pRegist.fillRegFields(data.get("min5"), fieldName);
                }else if (name.equalsIgnoreCase("less then 5 char")){
                    pRegist.fillRegFields(data.get("min4"), fieldName);
                }else if (name.equalsIgnoreCase("max 32 characters")){
                    pRegist.fillRegFields(data.get("max32"), fieldName);
                }else if (name.equalsIgnoreCase("max 33 characters")){
                    pRegist.fillRegFields(data.get("max33"), fieldName);
                }else if (name.equalsIgnoreCase("whitespaces")){
                    pRegist.fillRegFields(data.get("whiteSpace"), fieldName);
                }
                break;
            case "confirm password":
                if (name.equalsIgnoreCase("minimum 5 characters")){
                    pRegist.fillRegFields(data.get("min5"), fieldName);
                }else if (name.equalsIgnoreCase("alphanumeric and special char")) {
                    pRegist.fillRegFields(data.get("alfanumericSym"), fieldName);
                }else if (name.equalsIgnoreCase("less then 5 char")) {
                    pRegist.fillRegFields(data.get("min4"), fieldName);
                }else if (name.equalsIgnoreCase("max 32 characters")){
                    pRegist.fillRegFields(data.get("max32"), fieldName);
                }else if (name.equalsIgnoreCase("max 33 characters")){
                    pRegist.fillRegFields(data.get("max33"), fieldName);
                }else if (name.equalsIgnoreCase("whitespaces")){
                    pRegist.fillRegFields(data.get("whiteSpace"), fieldName);
                }
                break;
            default:
                throw new RuntimeException("provided incorrect field");
        }
    }

    @And("I click Register Me button")
    public void iClickRegisterMeButton() {
        pRegist.clickRegisterButton();
    }

    @Then("registration confirmation page is open")
    public void registrationConfirmationPageIsOpen() {
        assertThat(new RegistrationConfirmation().isRegisConfirm()).isTrue();
    }

    @Then("Message {string} appears")
    public void messageAppears(String message) {
        assertThat(pRegist.getErrMessage()).containsIgnoringCase(message);
    }

    @Then("Message {string} appears on the bottom")
    public void messageAppearsOnTheBottom(String message) {
        assertThat(pRegist.errMessageBar()).isTrue();
    }
}
