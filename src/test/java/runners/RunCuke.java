package runners;

import context.ScenarioContext;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(CustomRunner.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},

        tags = {"@Run"},
        features = {"src/test/resources/features"},
        glue = {
//                "hooks",
                "steps"}
)
public class RunCuke {

    @Autowired
    ScenarioContext scenarioContext;

}
