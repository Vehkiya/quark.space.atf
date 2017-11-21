package page;

import page.common.AbstractPage;
import page.common.Locator;
import page.common.PageAccessor;
import webdriver.Browser;

@PageAccessor(name = "login", url = "users/sign_in")
public class BasicPage extends AbstractPage {
    public BasicPage(Browser browser) {
        super(browser);
    }

    @Locator(name = "locator1", id = "user_email")
    private String locator1;


}
