package PageObject;


import Config.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class BasePage {
    private WebDriver driver;
    private int tiempoEspera = 10;
    private int tiempoConsulta = 2;
    private int tiempoEsperaMax = 20;
    private String url;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        this.driver.get(url);
    }

    public BasePage(WebDriver driver, int tiempoEspera, int tiempoConsulta, String url) {
        this.driver = driver;
        this.tiempoEspera = tiempoEspera;
        this.tiempoConsulta = tiempoConsulta;
        this.url = url;
    }

    public void chromeDriverConnetion() {
        ChromeOptions options = new ChromeOptions();
        String r = Properties.pathChromeDriver;
        System.out.println("[Info]Ruta driver " + r);
        System.setProperty("webdriver.chrome.driver", r);

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.setPageLoadTimeout(Duration.ofSeconds(60));
        this.driver = new ChromeDriver(options);
    }
    public void getUrl(String utl){
        this.driver.get(utl);
    }
    public void quit() {
        this.driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    //Similar al Sleeep, solo que este espera que cargue la WebDriver
    public void implicitWait() {
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(tiempoEspera));
    }

    //Esperamos un elemento en particular y con alguna condicion definida
    //Una ves q lo encuentra devuelve el objeto y continua con el siguie paso
    public WebElement explicitWait(By location) {
        WebElement firstResult = new WebDriverWait(this.driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(location));

        return firstResult;
    }

    //Constantemente esta preguntando el estado de la pagina
    //Tomando comun maximo un tiempo y un tiempo de consulta itinerante
    //Espera 10segundo, pero consulta el estado cada 2segundo
    //A diferencia del Explicit, este constantemente consulta al DOM(los elemento de la pagina)
    //hasta que lo encuentra, pero lo hace en un determinado tiempo como maximo.
    public WebElement fluentWait(By location) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
                .withTimeout(Duration.ofSeconds(this.tiempoEsperaMax))//Tiempo maximo de espera
                .pollingEvery(Duration.ofSeconds(this.tiempoConsulta))//Tiempo entre consulta
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        WebElement firstResult = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(location);
            }
        });
        return firstResult;
    }

    //BUSCAMOS ELEMENTOS

    //wrapper,wrapping embolotorio de metodo
    //Recumeramos un objeto en particular
    public WebElement findElement(By location) {
        return this.driver.findElement(location);
    }

    //Recuperamos varios objetos
    public List<WebElement> findElements(By location) {
        return this.driver.findElements(location);
    }

    //MODIFICAMOS ELEMENTOS EN EL SIITO
    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By location) {
        return this.driver.findElement(location).getText();
    }

    public void typeText(WebElement element, String texto) {
        element.sendKeys(texto);
    }

    public void typeText(By location, String texto) {
        this.driver.findElement(location).sendKeys(texto);
    }

    //ACCIONES DE ELEMENTOS
    public void submint(By location) {
        this.driver.findElement(location).submit();
    }

    public void submint(WebElement element) {
        element.submit();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void click(By location) {
        this.driver.findElement(location).click();
    }

    public Boolean isDisplayed(By location) {
        try {
            return this.driver.findElement(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    //Detiene la ejecucion y no tiene en cuenta que cargue el WebDriver
    public void sleepWait() {
        try {
            Thread.sleep(20000);
        } catch (Exception e) {

        }
    }

    @Override
    public String toString() {
        return "BasePage{" +
                "driver=" + driver +
                ", tiempoEspera=" + tiempoEspera +
                ", tiempoConsulta=" + tiempoConsulta +
                ", url='" + url + '\'' +
                '}';
    }
}
