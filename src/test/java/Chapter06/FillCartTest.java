package Chapter06;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
  1 testscenario per class.
  aanroepen van de driver apart --> protected webdriver.
 huiswerk
 */

@Test
public class FillCartTest {

    protected WebDriver driver;

    public void login() {

    ChromeDriverManager.getInstance().setup();
    driver = new ChromeDriver();

        // Maximaliseer browser window
        driver.manage().window().maximize();

        driver.get("https://techblog.polteq.com/testshop/index.php");


        // Valideer dat het winkelwagentje leeg is (tip: gebruik .isDisplayed(), empty is een element opzich)
        // <span class="ajax_cart_no_product" style="display: inline-block;">(empty)</span>
        Assertions.assertThat(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed());

        //4. Click op <ipod> bij het onderdeel TAGS (Tip: Bouw een CSS locator aan de hand van een attribuut)
        //clickableElements.add(webDriver.findElements(By.cssSelector("a[title*='price']"));
        driver.findElement(By.cssSelector("a[title='More about ipod']")).click();

        // 5. Click op de naam van <iPod shuffle> zodat de product pagina wordt geopened (Tip: bouw een xPath locator aan de hand van de tekst van het element)
        // <a class="product-name" href="https://techblog.polteq.com/testshop/index.php?id_product=2&amp;controller=product" title="iPod shuffle" itemprop="url"> iPod shuffle </a>
        //div[@id='container'][1]/*[1]
        driver.findElement(By.xpath("//*[@class='product-name' and contains(text(),'iPod shuffle')]")).click();

        //6. Voeg de <iPod Shuffle> toe aan de cart (Tip: na een paar keer vastlopen, kijk hoger in de DOM)
        //<a id="button_order_cart" class="btn btn-default button button-small" href="https://techblog.polteq.com/testshop/index.php?controller=order" title="Check out" rel="nofollow">
        driver.findElement(By.xpath(".//a[(@id='button_order_cart' and contains(@title,'Check out'))]")).click();

        //driver.findElement(By.id("email")).sendKeys("tester@test.com");
        //driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        //driver.findElement(By.id("SubmitLogin")).click();

        // validate if the logout link is displayed
        //Assertions.assertThat(driver.findElement(by.cssSelector("a.logout");

        //class header user info is altijd aanwezig daar kan je ook naar kijken

        driver.quit();
    }

}

