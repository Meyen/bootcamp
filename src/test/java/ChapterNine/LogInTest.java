package ChapterNine;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();

        // maximize the window
        driver.manage().window().maximize();

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
    public void shutDown() {
        //afsluiten browser
        driver.quit();
    }

    @Test
    public void SignIn() {
        driver.findElement(By.className("login")).click();

        driver.findElement(By.id("email")).sendKeys("tester@test.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();

        String controletekst;
        controletekst = "Welcome to your account. Here you can manage all of your personal information and orders.";

        String textmyaccount;
        textmyaccount = driver.findElement(By.id("my-account")).getText();

        Assertions.assertThat(textmyaccount).as("tekst op login pagina").contains(controletekst);
    }
}
