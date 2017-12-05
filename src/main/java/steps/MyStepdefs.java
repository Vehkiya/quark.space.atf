package steps;

import common.logs.LoggerFactory;
import context.ScenarioContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import webdriver.BrowserFactory;

public class MyStepdefs {

    @Autowired
    ScenarioContext scenarioContext;

    @Autowired
    BrowserFactory browserFactory;

    Logger logger = LoggerFactory.getLogger(MyStepdefs.class);


    @Given("^test step$")
    public void testStep() throws Throwable {
        logger.info("BOOBITY");
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
