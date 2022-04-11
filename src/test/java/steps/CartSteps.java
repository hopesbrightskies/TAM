package steps;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.CartPage;
import pages.CategoriesPage;

public class CartSteps {

    private final CartPage cartPage = new CartPage(Hooks.getDriver());

    @Then("Selected product is in the Cart")
    public void verifyProductIsInCart() {
        Assertions.assertTrue(cartPage.isProductInCart(CategoriesPage.getProductID(), CategoriesPage.getProductName()));
    }

}
