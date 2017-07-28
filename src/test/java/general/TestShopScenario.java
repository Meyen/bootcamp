package general;

import Browser.BrowserFactoryAdvanced;
import Browser.BrowserFactoryBasic;
import Browser.BrowserFactoryMedior;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Gerry on 20/07/2017.
 */
public class TestShopScenario {

    protected WebDriver driver;

    @BeforeMethod
    public void SetUp() {
        driver = BrowserFactoryMedior.getDriver("CHROME");

        // Maximaliseer browser window
        driver.manage().window().maximize();

        //open the website
        driver.get("https://techblog.polteq.com/testshop");

        // Open the website
        driver.get("https://techblog.polteq.com/testshop/index.php");

        //Valideer dat er niemand is ingelogd.

        String controleTextLogIn;
        controleTextLogIn = "Sign in";

        String textmyaccount;
        textmyaccount = driver.findElement(By.cssSelector("a[title='Log in to your customer account']")).getText();

        Assertions.assertThat(textmyaccount)
                .as("sign in is aanwezig")
                .contains(controleTextLogIn);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
