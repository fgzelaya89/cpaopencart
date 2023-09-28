package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By myAccount = By.cssSelector(".dropdown .hidden-xs");
    private By idPassword = By.id("password");


    public HomePage(WebDriver driver) {
        super(driver);
    }



}
