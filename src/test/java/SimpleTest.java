import common.error.ATFException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import page.LoginPage;
import webdriver.Browser;
import webdriver.BrowserFactory;
import webdriver.configuration.DriverConfig;

import static webdriver.fixture.BrowserName.FIREFOX;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DriverConfig.class})
public class SimpleTest {

    @Autowired
    private BrowserFactory browserFactory;

    @Test
    public void verifyShit() throws ATFException {
        Browser browser = browserFactory.getBrowser(FIREFOX);
        LoginPage loginPage = new LoginPage(browser);
        browser.getPage(loginPage);
        System.out.println();
    }
}
