import actions.BrowserActions;
import common.error.ATFException;
import configuration.SpringConfig;
import context.ScenarioContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import page.factory.PageFactory;
import webdriver.BrowserFactory;
import webdriver.fixture.BrowserName;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class SimpleTest {

    @Autowired
    private BrowserFactory browserFactory;

    @Autowired
    private PageFactory pageFactory;

    @Autowired
    private ScenarioContext scenarioContext;

    @Autowired
    private BrowserActions browserActions;

    @Test
    public void verifyShit() throws ATFException {
        browserFactory.getBrowser(BrowserName.CHROME);
        System.out.println("");

    }
}
