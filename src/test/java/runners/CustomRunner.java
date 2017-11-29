package runners;

import cucumber.api.junit.Cucumber;
import cucumber.runtime.junit.FeatureRunner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import java.io.IOException;

public class CustomRunner extends Cucumber {

    public CustomRunner(Class clazz) throws InitializationError, IOException {
        super(clazz);
    }

    @Override
    protected void runChild(FeatureRunner child, RunNotifier notifier) {
        super.runChild(child, notifier);
    }
}
