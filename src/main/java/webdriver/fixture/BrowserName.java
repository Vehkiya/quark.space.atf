package webdriver.fixture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Arrays;
import java.util.Optional;

public enum BrowserName {
    CHROME(ChromeDriver.class, "chrome"),
    FIREFOX(FirefoxDriver.class, "firefox"),
    IE(InternetExplorerDriver.class, "ie"),
    EDGE(EdgeDriver.class, "edge"),
    SAFARI(SafariDriver.class, "safari");

    Class<? extends WebDriver> driverClass;
    String description;

    BrowserName(Class<? extends WebDriver> driverClass, String description) {
        this.driverClass = driverClass;
        this.description = description;
    }

    public Class<? extends WebDriver> getDriverClass() {
        return driverClass;
    }

    public static BrowserName getByClass(Class<? extends WebDriver> driverClass) {
        return Arrays.asList(BrowserName.values()).stream().filter(b -> b.getDriverClass().equals(driverClass)).findFirst().get();
    }

    public static BrowserName getByDescription(String description) {
        Optional<BrowserName> browserName = Arrays.stream(BrowserName.values())
                .filter(bn -> bn.description.equalsIgnoreCase(description.trim())).findFirst();
        return browserName.orElse(null);
    }
}
