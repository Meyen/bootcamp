package ChapterNine;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NOK_FillInContactFormTest {
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
    public void FillInContactForm() {
        // klik op contact us
        driver.findElement(By.cssSelector("a[title='Contact us']")).click();

        // Selecteer customer service
        Select dropdown = new Select(driver.findElement(By.id("id_contact")));
        dropdown.selectByVisibleText("Customer service");

        //vul email nope in
        driver.findElement(By.id("email")).sendKeys("nope");

        //vul order reference 4321234
        driver.findElement(By.id("id_order")).sendKeys("4321234");

        //Message:Help!
        driver.findElement(By.id("message")).sendKeys("Help!");

        //Send Mail
        driver.findElement(By.id("submitMessage")).click();

        //Valideer dat er een foutboodschap verschijnt.
        String foutboodschap = driver.findElement(By.xpath(".//*[@id='center_column']/div/p")).getText();
        Assertions.assertThat(foutboodschap).contains("There is 1 error");

    }
}
