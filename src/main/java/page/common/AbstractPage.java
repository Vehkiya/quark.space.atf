package page.common;

import webdriver.Browser;

public abstract class AbstractPage implements Page {

    private Browser browser;
    private String url;
    private String pageName;

    public AbstractPage(Browser browser) {
        this.browser = browser;
    }

    public String getPageName() {
        return this.pageName;
    }

    public String getUrl() {
        return this.url;
    }

    @Override
    public void open() {
        browser.get(url);
    }

    @Override
    public void refresh() {
        browser.navigate().refresh();
    }

    @Override
    public String getPageTitle() {
        return browser.getTitle();
    }

    @Override
    public Boolean isCurrentPage() {
        return browser.getCurrentUrl().startsWith(url);
    }
}
