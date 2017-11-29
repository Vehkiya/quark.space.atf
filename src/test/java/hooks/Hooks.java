package hooks;

import common.error.ATFException;
import context.ScenarioContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import webdriver.BrowserFactory;
import webdriver.fixture.BrowserName;

public class Hooks {

    @Autowired
    private ScenarioContext scenarioContext;

    @Value("${active.browser}")
    private String activeBrowserSet;

    @Autowired
    private BrowserFactory browserFactory;

    @Before
    public void setUp() throws Exception {
        BrowserName name = BrowserName.getByDescription(activeBrowserSet);
        if (name == null) {
            throw new ATFException("Invalid browser");
        }
        scenarioContext.setBrowser(browserFactory.getBrowser(name));
    }

    @After
    public void tearDown() throws Exception {
        scenarioContext.getBrowser().close();
        scenarioContext.resetResource();
    }
}
