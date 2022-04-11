package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.CategoriesPage;

public class CategoriesSteps {

    private final CategoriesPage categoriesPage = new CategoriesPage(Hooks.getDriver());

    @And("^Click on Add to cart button (.+) product")
    public void addToCart(int number) {
        categoriesPage.addToCart(number);
    }

    @Then("^Adding to Cart popup (.+) is shown")
    public void verifyAddingToCartPopup(String message){
        Assertions.assertTrue(categoriesPage.isProductAddedToCart(message));
    }

    @When("I click Proceed to checkout")
    public void proceedToCheckout(){
        categoriesPage.clickProceedToCheckout();
    }
}
