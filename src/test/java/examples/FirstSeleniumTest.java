package examples;

import general.TestShopScenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Gerry on 19/07/2017.
 */
public class FirstSeleniumTest extends TestShopScenario {

    @Test
    public void logInSuccesFull() {

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
