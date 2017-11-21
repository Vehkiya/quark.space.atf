package page;

import page.common.AbstractPage;
import page.common.Locator;
import webdriver.Browser;

public class BasicPage extends AbstractPage {
    public BasicPage(Browser browser) {
        super(browser);
    }

    private String nonlocator;

    @Locator
    private String locator1;

    @Locator
    private String locator2;

}
