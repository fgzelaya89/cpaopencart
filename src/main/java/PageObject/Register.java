package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Register {
    public static By firstname = By.id("input-firstname");
    public static By lastname = By.id("input-lastname");
    public static By email = By.id("input-email");
    public static By telephone = By.id("input-telephone");
    public static By password = By.id("input-password");
    public static By confirm = By.id("input-confirm");
    public static By  checkPrivacyPolicy  = By.name("agree");
    public static By  btnContinue  = By.cssSelector(".btn-primary");
    public static By successRegister = By.id("content");

    public static void clickElementTypeTex(WebDriver webDriver,By byElement,String text){
        webDriver.findElement(byElement).sendKeys(text);
    }


    public static void clickElement(WebDriver webDriver,By byElement){
        webDriver.findElement(byElement).click();
    }

    public static  WebElement  getWebElement(WebDriver webDriver, By byElement){
        return  webDriver.findElement(byElement);
    }




}
