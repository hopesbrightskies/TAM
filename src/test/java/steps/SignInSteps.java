package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.SignInPage;

public class SignInSteps {

    private final SignInPage signInPage = new SignInPage(Hooks.getDriver());

    @And("^fill (.+) into Email field")
    public void fillEmail(String email) {
        if (!email.equals("empty")) {
            signInPage.fillEmail(email);
        }
    }

    @And("^fill (.+) into Password field")
    public void fillPassword(String password) {
        if (!password.equals("empty")) {
            signInPage.fillPassword(password);
        }
    }

    @And("click on Sign in button")
    public void pressSignIn() {
        signInPage.pressSignIn();
    }

    @Then("^The validation (.+) is displayed")
    public void errorMessageIsDisplayed(String message) {
        Assertions.assertTrue(signInPage.isMessageShown(message), "Error message is not displayed.");
    }

}
