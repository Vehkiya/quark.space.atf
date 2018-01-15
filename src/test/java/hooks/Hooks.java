package hooks;

import common.logs.LoggerFactory;
import context.ScenarioContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import webdriver.Browser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static java.io.File.separator;

public class Hooks {

    @Autowired
    private Browser browser;

    @Autowired
    private ScenarioContext scenarioContext;

    @Value("${find.on.page.timeout}")
    private Long defaultFindTimeout;

    private Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before(order = 0)
    public void prepareScenario(Scenario scenario) throws Exception {
        String startTimestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MMM-dd_HHmmssSSS"));
        String currentEvidencePath = String.format("target%slogs%s%s_%s%stest.log", separator, separator, startTimestamp, scenario.getName(), separator);
        scenarioContext.setCurrentEvidencePath(currentEvidencePath);
        Appender appender = logger.getParent().getAppender("CONSOLE");
        Appender fileAppender = new FileAppender(appender.getLayout(), currentEvidencePath);
        logger.getParent().addAppender(fileAppender);
        logger.info("Creating scenario workspace");
    }

    @Before(order = 1)
    public void setUp() throws Exception {
        browser.manage().timeouts().pageLoadTimeout(defaultFindTimeout, TimeUnit.SECONDS);
        browser.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        browser.close();
        scenarioContext.resetResource();
    }
}
