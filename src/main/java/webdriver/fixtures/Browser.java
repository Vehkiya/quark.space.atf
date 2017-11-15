package webdriver.fixtures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public enum Browser {
    CHROME(ChromeDriver.class),
    FIREFOX(FirefoxDriver.class),
    IE(InternetExplorerDriver.class),
    EDGE(EdgeDriver.class),
    SAFARI(SafariDriver.class);

    Class<? extends WebDriver> driverClass;

    Browser(Class<? extends WebDriver> driverClass) {
        this.driverClass = driverClass;
    }

    public Class<? extends WebDriver> getDriverClass() {
        return driverClass;
    }
}
