package steps;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.Categories;
import utils.SubCategories;


public class HomeSteps {

    private final HomePage homePage = new HomePage(Hooks.getDriver());

    @Given("Home page is open")
    public void openPage() {
        homePage.openPage();
    }

    @When("I click on Sign in link")
    public void clickSignInLink() { homePage.clickSignInLink(); }

    @When("I click on Contact us link")
    public void clickContactUsLink() { homePage.clickContactUsLink(); }

    @When("^I perform search for (.+)")
    public void search(String product) {homePage.searchFor(product);}

    @When("^I select (.+) and (.+) from the Menu")
    public void selectInMenu(Categories category, SubCategories subcategory) {homePage.selectProduct(category, subcategory);}

}
