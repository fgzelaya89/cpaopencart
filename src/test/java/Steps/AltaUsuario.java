package Steps;

import Config.Properties;
import PageObject.HomePage;
import PageObject.Register;
import com.github.javafaker.Faker;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class AltaUsuario {
    private HomePage homePage;
    private WebDriver webDriverHomePage;
    private Faker faker = new Faker();

    @Given("Paso Uno")
    public void pasoUno() {
        ChromeOptions options = new ChromeOptions();
        String r = Properties.pathChromeDriver;
        System.out.println("[Info]Ruta driver " + r);
        System.setProperty("webdriver.chrome.driver", r);

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.setPageLoadTimeout(Duration.ofSeconds(60));

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://opencart.abstracta.us/");
    }


    @Given("ingresamo al sitio {string}")
    public void ingresamoAlSitio(String url) {
        homePage = new HomePage(Properties.driver);
        homePage.chromeDriverConnetion();
        homePage.getUrl(url);
    }

    @And("hacemos clic en {string}")
    public void hacemosClicEn(String clicMyAccount) {
        homePage.findElement(By.linkText(clicMyAccount)).click();
    }

    @After
    public void After() {
        System.out.println("Fin");
        homePage.quit();
    }

    @When("hace clic en el boton continue")
    public void haceClicAceptar() {
        Register.clickElement(this.homePage.getDriver(), Register.btnContinue);
    }

    @Then("se valida q devuelve ok")
    public void seValidaQDevuelveOk() {
    }

    @And("ingreso FirstName")
    public void ingresoFirstName() {
        String firstName = faker.name().firstName();
        System.out.println("[INFO] Ingresamos el siguiente dato: " + firstName);
        Register.clickElementTypeTex(this.homePage.getDriver(), Register.firstname, firstName);
    }

    @And("ingreso LastName")
    public void ingresoLastName() {
        String lastName = faker.name().lastName();
        System.out.println("[INFO] Ingresamos el siguiente dato: " + lastName);
        Register.clickElementTypeTex(this.homePage.getDriver(), Register.lastname, lastName);

    }

    @And("ingreso EMail")
    public void ingresoEMail() {
        String eMail = faker.internet().emailAddress();
        System.out.println("[INFO] Ingresamos el siguiente dato: " + eMail);
        Register.clickElementTypeTex(this.homePage.getDriver(), Register.email, eMail);
    }

    @And("ingreso Telephone")
    public void ingresoTelephone() {
        String telephone = faker.phoneNumber().cellPhone();
        System.out.println("[INFO] Ingresamos el siguiente dato: " + telephone);
        Register.clickElementTypeTex(this.homePage.getDriver(), Register.telephone, telephone);
    }

    @And("ingreso Password {string}")
    public void ingresoPassword(String Password) {
        System.out.println("[INFO] Ingresamos el siguiente dato: " + Password);
        Register.clickElementTypeTex(this.homePage.getDriver(), Register.password, Password);
    }

    @And("confirma Password {string}")
    public void confirmaPassword(String Password) {
        System.out.println("[INFO] Ingresamos el siguiente dato: " + Password);
        Register.clickElementTypeTex(this.homePage.getDriver(), Register.confirm, Password);
    }

    @And("acepta la Privacy Policy")
    public void aceptaLaPrivacyPolicy() {
        Register.clickElement(this.homePage.getDriver(), Register.checkPrivacyPolicy);
    }

    @Then("se valida el mensaje successfully created")
    public void seValidaElMensajeSuccessfullyCreated() {
        WebElement account = Register.getWebElement(this.homePage.getDriver(), Register.successRegister);
        String txtRecuperado = account.getText();
        boolean contiene = txtRecuperado.contains("Congratulations! Your new account has been successfully created!");
        Assert.assertTrue("[Warning] No se registro el usuario ", contiene);
    }

    @Given("que una persona ingresa a la página OpenCart")
    public void queUnaPersonaIngresaALaPáginaOpenCart() {
        homePage = new HomePage(Properties.driver);
        homePage.chromeDriverConnetion();
        homePage.getUrl(Properties.urlOpenCartHome);
    }

    @When("hace clic en el dropBox {string} y selecciona {string}")
    public void haceClicEnElDropBoxYSelecciona(String dropBox, String dropBoxOpcion) {
        homePage.findElement(By.linkText(dropBox)).click();
        homePage.findElement(By.linkText(dropBoxOpcion)).click();
    }

    @And("completa el formulario de registro con datos válidos")
    public void completaElFormularioDeRegistroConDatosVálidos() {
        String firstName = faker.name().firstName();
        System.out.println("[INFO] Ingresamos el siguiente dato: " + firstName);
        Register.clickElementTypeTex(this.homePage.getDriver(), Register.firstname, firstName);

        String lastName = faker.name().lastName();
        System.out.println("[INFO] Ingresamos el siguiente dato: " + lastName);
        Register.clickElementTypeTex(this.homePage.getDriver(), Register.lastname, lastName);

        String eMail = faker.internet().emailAddress();
        System.out.println("[INFO] Ingresamos el siguiente dato: " + eMail);
        Register.clickElementTypeTex(this.homePage.getDriver(), Register.email, eMail);

        String telephone = faker.phoneNumber().cellPhone();
        System.out.println("[INFO] Ingresamos el siguiente dato: " + telephone);
        Register.clickElementTypeTex(this.homePage.getDriver(), Register.telephone, telephone);

        String password = "123Icaro";
        System.out.println("[INFO] Ingresamos el siguiente dato: " + password);
        Register.clickElementTypeTex(this.homePage.getDriver(), Register.password, password);

        System.out.println("[INFO] Ingresamos el siguiente dato: " + password);
        Register.clickElementTypeTex(this.homePage.getDriver(), Register.confirm, password);
    }

    @And("acepta las condiciones de {string} de la registracion")
    public void aceptaLasCondicionesDeDeLaRegistracion(String arg0) {
        System.out.println("[INFO] acepta las condiciones de " + arg0 + " de la registracion");
        Register.clickElement(this.homePage.getDriver(), Register.checkPrivacyPolicy);
    }

    @And("hace clic en el botón {string} de la registracion")
    public void haceClicEnElBotónDeLaRegistracion(String arg0) {
        System.out.println("[INFO] hace clic en el botón " + arg0 + " de la registracion");
        Register.clickElement(this.homePage.getDriver(), Register.btnContinue);
    }

    @Then("la página de registro debe mostrar el mensaje de {string}")
    public void laPáginaDeRegistroDebeMostrarElMensajeDe(String arg0) {
        System.out.println("[INFO] La página de registro debe mostrar el mensaje de " + arg0 + "");
        WebElement account = Register.getWebElement(this.homePage.getDriver(), Register.successRegister);
        String txtRecuperado = account.getText();
        boolean contiene = txtRecuperado.contains(arg0);
        Assert.assertTrue("[Warning]La página de registro no muestra  el mensaje "+arg0, contiene);
    }
}