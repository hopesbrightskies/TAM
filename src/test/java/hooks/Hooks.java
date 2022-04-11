package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.*;

public class Hooks {

    private static WebDriver driver;
    public CommonStep commonStep;
    public HomeSteps homeSteps;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Nadiia_Rusakova/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        commonStep = new CommonStep();
        homeSteps = new HomeSteps();
    }

    @After
    public void tearDownAll() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
