import actions.BrowserActions;
import common.error.ATFException;
import configuration.AtfSpringConfig;
import context.ScenarioContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import page.factory.PageFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AtfSpringConfig.class})
public class SimpleTest {

    @Autowired
    private PageFactory pageFactory;

    @Autowired
    private ScenarioContext scenarioContext;

    @Autowired
    private BrowserActions browserActions;

    @Test
    public void verifyShit() throws ATFException {
//        pageFactory.getPage(BasicPage.class);
        System.out.println("");

    }
}
