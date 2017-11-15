package webdriver;

import common.error.ATFException;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webdriver.fixtures.Browser;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

@Service
public class DriverFactory {

    private Properties driverProperties;

    private static Browser browser;

    private static WebDriver webDriver;

    public DriverFactory(@Autowired Properties driverProperties) {
        this.driverProperties = driverProperties;
        System.setProperties(driverProperties);
    }

    public static Browser getBrowser() {
        return browser;
    }

    public WebDriver getDriverForBrowser(Browser browser) throws ATFException {
        if (webDriver == null) {
            try {
                browser.getDriverClass().getConstructor().setAccessible(true);
                webDriver = browser.getDriverClass().getConstructor().newInstance();
            } catch (NoSuchMethodException e) {
                throw new ATFException(String.format("No constructor available for class %s", browser.getDriverClass().getSimpleName()), e);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                if (e.getCause() instanceof IllegalStateException) {
                    throw new ATFException(String.format("Webdriver path property not set for %s", browser), e);
                }
                throw new ATFException(String.format("Failed to instantiate class of type %s", browser.getDriverClass().getSimpleName()), e);
            }
        }
        return webDriver;
    }
}
