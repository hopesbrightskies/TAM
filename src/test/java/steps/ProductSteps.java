package steps;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.ProductPage;
import pages.SearchPage;

public class ProductSteps {

    private final ProductPage productPage = new ProductPage(Hooks.getDriver());

    @Then("Name and Price are correct on Product details page")
    public void verifyNameAndPrice() {
        Assertions.assertTrue(productPage.verifyNameAndPrice(SearchPage.getProductName(), SearchPage.getProductPrice()));
    }
}
