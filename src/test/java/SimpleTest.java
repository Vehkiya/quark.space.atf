import common.error.ATFException;
import configuration.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import page.BasicPage;
import page.factory.PageFactory;
import webdriver.BrowserFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class SimpleTest {

    @Autowired
    private BrowserFactory browserFactory;

    @Autowired
    private PageFactory pageFactory;

    @Test
    public void verifyShit() throws ATFException {
//        Browser browser = browserFactory.getBrowser(FIREFOX);
//        AbstractPage page = new BasicPage(browser);
        pageFactory.scanPage(BasicPage.class);

    }
}
