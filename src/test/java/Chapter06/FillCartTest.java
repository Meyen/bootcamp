package Chapter06;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by Gerry on 20/07/2017.
 * Testcase 6.02 – Bestellen accessoires op de webshop
 Stappen:
 1. Maak in de package “chapterSix” een java class genaamd FillCartTest
 2. Open https://techblog.polteq.com/testshop/
 a. Maximize de browser window
 3. Valideer dat cart empty is (tip: gebruik .isDisplayed(), empty is een element opzich)
 4. Click op <ipod> bij het onderdeel TAGS (Tip: Bouw een CSS locator aan de hand van een attribuut)
 5. Click op de naam van <iPod shuffle> zodat de product pagina wordt geopened (Tip: bouw een xPath locator aan de hand van de tekst van het element)
 6. Voeg de <iPod Shuffle> toe aan de cart (Tip: na een paar keer vastlopen, kijk hoger in de DOM)
 7. Click op de knop continue shopping (tip: title als locator, idem als stap 4, selenium is sneller dan de site wellicht?)
 8. Valideer dat er nu 1 product zich in de cart bevindt (tip: nummer is een element opzich)
 */

@Test
public class FillCartTest {

    public void login() {

    ChromeDriverManager.getInstance().setup();
    WebDriver driver = new ChromeDriver();

        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.manage().window().maximize();

        driver.findElement(By.id("email")).sendKeys("tester@test.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();

        // validate if the logout link is displayed
        Assertions.assertThat(driver.findElement(by.cssSelector("a.logout");

        //class header user info is altijd aanwezig daar kan je ook naar kijken
        

        driver.quit();
    }

}
