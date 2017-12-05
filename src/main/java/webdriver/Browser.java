package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webdriver.fixture.BrowserName;

import java.util.List;
import java.util.Set;

public class Browser {
    private BrowserName browserName;
    private WebDriver webDriver;
    private String baseUrl;

    Browser(BrowserName browserName, WebDriver webDriver, String baseUrl) {
        this.browserName = browserName;
        this.webDriver = webDriver;
        this.baseUrl = baseUrl;
    }

    public void get(String s) {
        webDriver.get(baseUrl + s);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return webDriver.findElements(by);
    }

    public WebElement findElement(By by) {
        return webDriver.findElement(by);
    }

    public String getPageSource() {
        return webDriver.getPageSource();
    }

    public void close() {
        webDriver.close();
    }

    public void quit() {
        webDriver.quit();
    }

    public Set<String> getWindowHandles() {
        return null;
    }

    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    public WebDriver.TargetLocator switchTo() {
        return webDriver.switchTo();
    }

    public WebDriver.Navigation navigate() {
        return webDriver.navigate();
    }

    public WebDriver.Options manage() {
        return webDriver.manage();
    }

    public BrowserName getBrowserName() {
        return browserName;
    }
}
