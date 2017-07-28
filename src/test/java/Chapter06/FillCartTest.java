//package Chapter06;
//
//import general.TestShopScenario;
//import io.github.bonigarcia.wdm.ChromeDriverManager;
//import org.assertj.core.api.Assertions;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//@Test
//public void fillCart() throws InterruptedException{
//    WebDriverWait myWaitVar = new WebDriverWait(driver,20);
//
//    // Open the website
//        driver.get("https://techblog.polteq.com/testshop/index.php")
//        driver.manage().window.maximize();
//
//    // Check if empty element is visible
//        Assertions.assertThat(driver.findElement(By.classname("ajax_cart_no_product")).isDisplayed()).as("Check if empty element is visible.").isTrue()
//
//        //Click on the iPod Tag
//        driver.findElement(By.cssSelector("a[title-'More about ipod']")).click();
//
//        //Click on the ipod shuffle
//        driver.findElement(By.xpath("//a[contains(text(),'iPod shuffle]")).click();
//
//        //Add to cart
//        driver.findElement(By.id("add_to_cart")).click();
//
//
//
//}
//
