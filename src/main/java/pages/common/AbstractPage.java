package pages.common;

import webdriver.Browser;

public abstract class AbstractPage {
    private Browser browser;

    public AbstractPage(Browser browser) {
        this.browser = browser;
    }

    public Browser getBrowser() {
        return browser;
    }
}
