package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.logging.Level;

public class SignInPage extends CommonPage {

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(css = "#passwd")
    private WebElement passwordField;

    @FindBy(css = "#SubmitLogin")
    WebElement signInButton;

    @FindBy(css = "#center_column > div.alert.alert-danger > ol > li")
    WebElement errorMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void fillEmail(String email) {
        waiters.waitingForElementVisibility(emailField);
        emailField.sendKeys(email);
        LOG.log(Level.INFO, "Filling email address: " + email);
    }

    public void fillPassword(String password) {
        waiters.waitingForElementVisibility(passwordField);
        passwordField.sendKeys(password);
        LOG.log(Level.INFO, "Filling password: **** " );
    }

    public void pressSignIn() {
        waiters.waitingForElementVisibility(signInButton);
        signInButton.click();
        LOG.log(Level.INFO, "Signing in" );
    }

    public boolean isMessageShown(String message) {
        LOG.log(Level.INFO, "Message is shown: " + message );
        return waiters.waitingForTextPresence(errorMessage, message);
    }
}
