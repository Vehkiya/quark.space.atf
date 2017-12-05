package hooks;

import common.error.ATFException;
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
import webdriver.BrowserFactory;
import webdriver.fixture.BrowserName;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static java.io.File.separator;

public class Hooks {

    @Autowired
    private ScenarioContext scenarioContext;

    @Value("${active.browser}")
    private String activeBrowserSet;

    @Value("${find.on.page.timeout}")
    private Long defaultFindTimeout;

    private Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Autowired
    private BrowserFactory browserFactory;

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
        BrowserName name = BrowserName.getByDescription(activeBrowserSet);
        if (name == null) {
            throw new ATFException("Invalid browser");
        }
        logger.info("shit");
        Browser browser = browserFactory.getBrowser(name);
        browser.manage().timeouts().pageLoadTimeout(defaultFindTimeout, TimeUnit.SECONDS);
        browser.manage().window().maximize();
        scenarioContext.setBrowser(browser);
    }

    @After
    public void tearDown() throws Exception {
        if (scenarioContext.getBrowser() != null) {
            scenarioContext.getBrowser().close();
        }
        scenarioContext.resetResource();
    }
}
