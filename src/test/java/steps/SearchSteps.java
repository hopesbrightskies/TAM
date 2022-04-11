package steps;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;
import org.junit.jupiter.api.Assertions;

public class SearchSteps {

    private final SearchPage searchPage = new SearchPage(Hooks.getDriver());

    @Then("^Search results match (.+)")
    public void verifySearchResults(String product){
        Assertions.assertTrue(searchPage.getSearchResult().contains(product.toLowerCase()));
    }

    @When("^I choose (.+) product and Save name and price")
    public void chooseProduct(int number){
        searchPage.saveInfo(number);
    }

    @When("^I click the More button of (.+) product")
    public void clickMore(int number){
        searchPage.clickMoreButton(number);
    }

}
