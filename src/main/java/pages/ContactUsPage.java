package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Gerry on 21/07/2017.
 */
public class ContactUsPage {
    private WebDriver driver;

    @FindBy(css = "#email")
    private WebElement emailTextField; //alle elementen die we aanmaken in het Page Object Model zijn private.

    @FindBy(css = "input#id_order")
    private WebElement orderIdTextField;

    @FindBy(css = "textarea#message")
    private WebElement messageTextField;

    @FindBy(css = "button#submitMessage")
    private WebElement sendButton;


    //constructor (hardcoded, altijd nodig dingen

    public ContactUsPage(WebDriver driver){
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    public void fillInContactForm(String email, String orderId, String message){
        Select subjectHeading = new Select(driver.findElement(By.cssSelector("select#id_contact")));
        subjectHeading.selectByVisibleText("Customer service");

        emailTextField.sendKeys(email);
        orderIdTextField.sendKeys(orderId);
        messageTextField.sendKeys(message);
    }

    //controleer dat er geen user is ingelogd.
    //

}
