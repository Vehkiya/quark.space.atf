package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.common.AbstractPage;
import webdriver.fixture.BrowserName;

import java.util.List;
import java.util.Set;

public class Browser implements WebDriver {
    private BrowserName browserName;
    private WebDriver webDriver;
    private String baseUrl = "https://fentury.com/";

    public Browser(BrowserName browserName, WebDriver webDriver) {
        this.browserName = browserName;
        this.webDriver = webDriver;
    }

    @Override
    public void get(String s) {
        webDriver.get(baseUrl + s);
    }

    @Override
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return webDriver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webDriver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webDriver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return webDriver.getPageSource();
    }

    @Override
    public void close() {
        webDriver.close();
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return webDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return webDriver.navigate();
    }

    @Override
    public Options manage() {
        return webDriver.manage();
    }

    public BrowserName getBrowserName() {
        return browserName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void getPage(AbstractPage page) {
        get(page.getPageURL());
    }
}
