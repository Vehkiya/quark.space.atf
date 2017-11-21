package page.common;

import webdriver.Browser;

public abstract class AbstractPage {

    Browser browser;

    public AbstractPage(Browser browser) {
        this.browser = browser;
    }

    public String getPageName() {
        return this.getClass().getDeclaredAnnotation(Page.class).name();
    }

    public String getPageURL() {
        return this.getClass().getDeclaredAnnotation(Page.class).url();
    }
}
