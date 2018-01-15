package steps;

import common.logs.LoggerFactory;
import context.DataKey;
import context.ScenarioContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import page.PageType;
import page.common.elements.Locator;
import page.common.pages.Page;
import page.factory.PageFactory;
import page.pages.OverviewPage;
import webdriver.Browser;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Properties;

import static context.DataKey.CURRENT_PAGE;

public class MyStepdefs {

    @Autowired
    private ScenarioContext scenarioContext;

    @Autowired
    private PageFactory pageFactory;

    @Autowired
    private Browser browser;

    @Autowired
    @Qualifier("webProperties")
    private Properties webProperties;

    private Logger logger = LoggerFactory.getLogger(MyStepdefs.class);


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

    @Given("^user navigates to '(.*)' page$")
    public void userNavigatesToPage(String pageName) throws Throwable {
        Page page = pageFactory.getPage(PageType.getByPageName(pageName).getPageClass());
        Assert.assertTrue(page.isCurrentPage());
        scenarioContext.save(CURRENT_PAGE, page);
    }

    private WebElement getWebElementByName(final String field, final Page page) throws IllegalAccessException {
        Field classField = Arrays.stream(page.getClass().getDeclaredFields())
                                 .filter(f -> f.getAnnotation(Locator.class).name().equalsIgnoreCase(field))
                                 .findFirst().orElse(null);
        Assert.assertNotNull(classField);
        classField.setAccessible(true);
        return (WebElement) classField.get(page);
    }

    @And("^user inputs '(.*)' in the '(.*)' field$")
    public void userInputsTextInField(String text, String field) throws Throwable {
        Page page = (Page) scenarioContext.getDataByKey(DataKey.CURRENT_PAGE);
        Assert.assertTrue(page.isCurrentPage());
        WebElement webElement = getWebElementByName(field, page);
        webElement.sendKeys(text);
        Assert.assertThat("Text was input", webElement.getAttribute("value"), Matchers.is(text));
    }

    @And("^user inputs the saved '(.*)' in the '(.*)' field$")
    public void userInputsTheSavedValueInField(String propertyName, String field) throws Throwable {
        Page page = (Page) scenarioContext.getDataByKey(DataKey.CURRENT_PAGE);
        Assert.assertTrue(page.isCurrentPage());

        String value = webProperties.getProperty(propertyName);

        WebElement webElement = getWebElementByName(field, page);
        webElement.sendKeys(value);
        Assert.assertThat("Text was input", webElement.getAttribute("value"), Matchers.is(value));
    }

    @When("^user clicks '(.*)' button$")
    public void userClicksButton(String buttonName) throws Throwable {
        Page page = (Page) scenarioContext.getDataByKey(DataKey.CURRENT_PAGE);
        Assert.assertTrue(page.isCurrentPage());

        WebElement webElement = getWebElementByName(buttonName, page);
        webElement.click();
    }

    @Then("^'(.*)' page is displayed$")
    public void pageIsDisplayed(String pageName) throws Throwable {
        Page page = pageFactory.getPage(OverviewPage.class);

        Assert.assertTrue(page.isCurrentPage());
    }
}
