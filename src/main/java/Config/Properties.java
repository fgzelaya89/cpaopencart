package Config;

import PageObject.HomePage;
import org.openqa.selenium.WebDriver;

public class Properties {
    public static WebDriver driver;
    public static HomePage homePage;
    public static String pathChromeDriver = System.getProperty("user.dir") + "\\src\\main\\drivers\\chromedriver.exe";
    public static String urlOpenCartHome="https://opencart.abstracta.us/";
}
