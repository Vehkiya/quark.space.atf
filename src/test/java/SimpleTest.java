import common.error.ATFException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import webdriver.BrowserFactory;
import webdriver.configuration.DriverConfig;

import static webdriver.fixtures.BrowserName.FIREFOX;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DriverConfig.class})
public class SimpleTest {

    @Autowired
    private BrowserFactory factory;

    @Test
    public void verifyShit() throws ATFException {

        WebDriver webDriver = factory.getDriverForBrowser(FIREFOX);

        webDriver.get("https://fentury.com/users/sign_in");
    }
}
