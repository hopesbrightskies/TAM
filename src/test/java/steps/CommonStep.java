package steps;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import pages.CommonPage;

public class CommonStep {
    CommonPage commonPage = new CommonPage(Hooks.getDriver());

    @Given("^<page> is open$")
    public void openPage(String url) {
        commonPage.openPage(url);
    }

}
