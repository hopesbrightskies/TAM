package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.ContactUsPage;


public class ContactUsSteps {

    private final ContactUsPage contactUsPage = new ContactUsPage(Hooks.getDriver());

    @And("^I select Subject (.+)")
    public void selectSubject(String subject) { contactUsPage.selectSubject(subject);}

    @And("^I enter (.+) into Email address field")
    public void enterEmail(String email) {contactUsPage.enterEmail(email);}

    @And("^I enter (.+) into Order reference field")
    public void enterOrder(String order) {contactUsPage.enterOrderRef(order);}

    @And("^I enter (.+) into Message field")
    public void enterMsg(String message) {contactUsPage.enterMessage(message);}

    @And("^I click Send button")
    public void clickSend() {contactUsPage.clickSend();}

    @Then("^The text (.+) appears")
    public void checkAlert(String alert){
        Assertions.assertEquals(contactUsPage.getAlert(),alert);
    }

}
