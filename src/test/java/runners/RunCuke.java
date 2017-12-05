package runners;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CustomRunner.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        tags = {"@Run"},
        features = {"src/test/resources/features"},
        glue = {
                "hooks",
                "steps"}
)
public class RunCuke {


}
