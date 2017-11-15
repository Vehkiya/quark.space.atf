package webdriver.fixtures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Arrays;

public enum BrowserName {
    CHROME(ChromeDriver.class),
    FIREFOX(FirefoxDriver.class),
    IE(InternetExplorerDriver.class),
    EDGE(EdgeDriver.class),
    SAFARI(SafariDriver.class);

    Class<? extends WebDriver> driverClass;

    BrowserName(Class<? extends WebDriver> driverClass) {
        this.driverClass = driverClass;
    }

    public Class<? extends WebDriver> getDriverClass() {
        return driverClass;
    }

    public static BrowserName getByClass(Class<? extends WebDriver> driverClass) {
        return Arrays.asList(BrowserName.values()).stream().filter(b -> b.getDriverClass().equals(driverClass)).findFirst().get();
    }
}
