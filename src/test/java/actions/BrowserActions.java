package actions;

import context.ScenarioContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrowserActions {

    @Autowired
    private ScenarioContext scenarioContext;
}
