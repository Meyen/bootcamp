package homework;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Gerry on 23/07/2017.
 */

public class DeleteWishListTest {

    protected WebDriver driver;

    private static final String WISHLIST_NAME = "Feel the pain";

    @BeforeMethod
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();

        // maximize the window
        driver.manage().window().maximize();

        // Open the website
        driver.get("https://techblog.polteq.com/testshop/index.php");

        driver.findElement(By.className("login")).click();

        driver.findElement(By.id("email")).sendKeys("gerry@meyen.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();

        String controleTextLogIn;
        controleTextLogIn = "Gerry Meyen";

        String textmyaccount;
        textmyaccount = driver.findElement(By.xpath(".//*[@id='header']/div[1]/div/div/nav/div[2]/a/span")).getText();

        Assertions.assertThat(textmyaccount)
                .as("sign in = naam account")
                .contains(controleTextLogIn);
    }

    @Test
    public void wishListTest()  {
        //Go to wishlist
        driver.findElement(By.xpath(".//*[@id='center_column']/div/div[2]/ul/li[2]/a/span")).click();

        //lees de tabel wishlist
        WebElement table = driver.findElement(By.cssSelector(".table.table-bordered"));

        // boolean resultaatVerwijderen slaat resultaat op van oproepen method traverseTable (3 argumenten)
        boolean resultaatVerwijderen = this.traverseTable(table, Operatie.VERWIJDEREN, WISHLIST_NAME);
        System.out.println("Wishlist " + WISHLIST_NAME + " verwijderd: " + resultaatVerwijderen);

        boolean resultaatZoeken = this.traverseTable(table, Operatie.ZOEKEN, WISHLIST_NAME);
        System.out.println("Wishlist " + WISHLIST_NAME + " gevonden: " + resultaatZoeken);

        // Valideer dat de wishlist niet gevonden is.
        Assertions.assertThat(resultaatZoeken).isFalse();
    }

    @AfterMethod
    public void shutDown() {
        // Cleanup omgeving: voeg wishlist opnieuw toe
        driver.findElement(By.id("name")).sendKeys(WISHLIST_NAME);
        driver.findElement(By.id("submitWishlist")).click();

        //afsluiten browser
        driver.quit();
    }

    // wordt aangeroepen in de test
    private boolean traverseTable(WebElement table, Operatie operatie, String wishlist) {
        boolean gevonden = false;

        //data rows
        List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));

        //loop door alle rows (tr)
        for (int rowNumber = 0; rowNumber < rows.size(); rowNumber++) {
            WebElement row = rows.get(rowNumber);
            // zoek alle kolommen voor de huidige rij.
            List<WebElement> cols = row.findElements(By.tagName("td"));

            // loop over alle kolommen
            for (int colNumber = 0; colNumber < cols.size(); colNumber++) {
                WebElement col = cols.get(colNumber);
                // bevat de kolom de naam die we zoeken (Feel the pain)
                if (col.getText().equalsIgnoreCase(wishlist)) {
                    gevonden = true;
                }
                // indien gevonden EN operatie = VERWIJDEREN, dan zoeken we of er een delete link aanwezig is.
                if ((gevonden) && (operatie.equals(Operatie.VERWIJDEREN))) {
                    if (col.getAttribute("class").equalsIgnoreCase("wishlist_delete")) {
                        WebElement deleteLink = col.findElement(By.tagName("a"));
                        // indien delete link aanwezig delete
                        if (deleteLink != null) {
                            deleteLink.click();
                            // bevestig delete pop-up
                            driver.switchTo().alert().accept();
                        }

                        return gevonden;
                    }
                }
            }
        }

        return false;
    }

    private enum Operatie {
        VERWIJDEREN, ZOEKEN
    }

}
