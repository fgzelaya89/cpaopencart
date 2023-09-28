

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        plugin = {"pretty"},
        tags = "@AltaUsuario", glue = {"Steps"})

public class RunCucumberTest {

    @BeforeClass
    public static void BeforeClass() {
        System.out.println("[INFO] Incio de ejecucion ");
    }

    @AfterClass
    public static void AfterClass() {
        System.out.println("[INFO] Fin de ejecucion ");
    }
}


