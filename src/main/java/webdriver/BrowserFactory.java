package webdriver;

import common.error.ATFException;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webdriver.fixture.BrowserName;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

@Service
public class BrowserFactory {

    @Autowired
    private Browser browser;

    public BrowserFactory(@Autowired Properties driverProperties) {
        Properties properties = System.getProperties();
        driverProperties.forEach(properties::putIfAbsent);
        System.setProperties(properties);
    }

    public Browser getBrowser(BrowserName browserName) throws ATFException {
        return new Browser(browserName, getWebdriver(browserName.getDriverClass()));
    }

    public Browser getBrowser() {
        return browser;
    }

    private WebDriver getWebdriver(Class<? extends WebDriver> webDriverClass) throws ATFException {

        Constructor constructor;
        try {
            constructor = webDriverClass.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new ATFException("Could not find default constructor for " + webDriverClass.getSimpleName(), e);
        }
        constructor.setAccessible(true);
        try {
            return (WebDriver) constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new ATFException(e.getMessage(), e);
        }
    }
}
