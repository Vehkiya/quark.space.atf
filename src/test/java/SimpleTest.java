import common.error.ATFException;
import configuration.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import webdriver.Browser;
import webdriver.BrowserFactory;

import static webdriver.fixture.BrowserName.FIREFOX;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class SimpleTest {

    @Autowired
    private BrowserFactory browserFactory;

    @Test
    public void verifyShit() throws ATFException {
        Browser browser = browserFactory.getBrowser(FIREFOX);

    }
}
