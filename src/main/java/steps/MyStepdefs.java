package steps;

import context.ScenarioContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import webdriver.BrowserFactory;

public class MyStepdefs {

    @Autowired
    ScenarioContext scenarioContext;

    @Autowired
    BrowserFactory browserFactory;


    @Given("^test step$")
    public void testStep() throws Throwable {

        System.out.println("BOOB");
    }

    @And("^another step$")
    public void anotherStep() throws Throwable {
        System.out.println("BOOP");
    }

    @Given("^write '(.*)'$")
    public void writeILoveYou(String text) throws Throwable {
        System.out.println(text);
    }
}
