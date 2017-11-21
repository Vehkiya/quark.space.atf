package webdriver;

import common.error.ATFException;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import webdriver.fixture.BrowserName;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

@Service
public class BrowserFactory {

    private static WebDriver webDriver;

    @Value("${base.url}")
    private String baseUrl;

    public BrowserFactory(@Autowired Properties driverProperties) {
        Properties properties = System.getProperties();
        driverProperties.forEach(properties::putIfAbsent);
        System.setProperties(properties);
    }

    private WebDriver getDriverForBrowser(Class<? extends WebDriver> driverClass) throws ATFException {
        if (webDriver == null) {
            try {
                driverClass.getConstructor().setAccessible(true);
                webDriver = driverClass.getConstructor().newInstance();
            } catch (NoSuchMethodException e) {
                throw new ATFException(String.format("No constructor available for class %s", driverClass.getSimpleName()), e);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                if (e.getCause() instanceof IllegalStateException) {
                    throw new ATFException(String.format("Webdriver path property not set for %s", BrowserName.getByClass(driverClass)), e);
                }
                throw new ATFException(String.format("Failed to instantiate class of type %s", driverClass.getSimpleName()), e);
            }
        }
        return webDriver;
    }

    public Browser getBrowser(BrowserName browserName) throws ATFException {
        return new Browser(browserName, getDriverForBrowser(browserName.getDriverClass()), baseUrl);
    }
}
