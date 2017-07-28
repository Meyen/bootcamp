package Browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.security.krb5.internal.crypto.Des;

public class BrowserFactoryMedior {
    public static WebDriver getDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                return   createFireFoxBrowser();
            case "chrome":
                return  createChromeBrowser();
            default:
                return  createChromeBrowser();
        } //end switch
    }






    private static WebDriver createChromeBrowser(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //Chrome options are chrome specific
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("ignore-certificate-errors");
        //Capabilities can be used for Webdriver capabilities ie: proxy
        capabilities.setCapability("chrome.switches", "--verbose");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(capabilities);
    }

    private static WebDriver createFireFoxBrowser(){
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver(capabilities);

    }
}
