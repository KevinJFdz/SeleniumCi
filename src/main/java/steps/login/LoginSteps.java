package steps.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.cucumber.CucumberManager;

public class LoginSteps {
    LoginFunctions loginFunctions= new LoginFunctions();
    LoginAsserts loginAsserts = new LoginAsserts();

    @Given("the user is on login section")
    public void theUserIsOnLoginSection() {
        loginFunctions.visitLoginPage();
    }

    @When("the login enters his credentials")
    public void theLoginEntersHisCredentials() {
        loginFunctions.login("standard_user", "secret_sauce");
    }

    @Then("the app should be display the main section")
    public void theAppShouldBeDisplayTheMainSection() {
        CucumberManager.attachScreenshotToReport();
        loginAsserts.assertSuccessfullyLogin();
    }
}
