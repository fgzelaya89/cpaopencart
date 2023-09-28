

import Config.Properties;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources",tags = "@Test",glue = {"Steeps"})

public class RunCucumberTest {

    @AfterClass
    public static void AfterClass(){
        System.out.println("AfterClass");
    }
}


