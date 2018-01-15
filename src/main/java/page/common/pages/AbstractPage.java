package page.common.pages;

import webdriver.Browser;

public abstract class AbstractPage implements Page {

    private Browser browser;
    private String url;
    private String pageName;

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

    public Browser getBrowser() {
        return browser;
    }

    public AbstractPage setBrowser(final Browser browser) {
        this.browser = browser;
        return this;
    }

    public AbstractPage setUrl(final String url) {
        this.url = url;
        return this;
    }

    public AbstractPage setPageName(final String pageName) {
        this.pageName = pageName;
        return this;
    }
}
