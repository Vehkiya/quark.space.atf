package page;

import page.common.AbstractPage;
import page.common.Page;
import webdriver.Browser;
import webelement.Button;
import webelement.common.Locator;

@Page(name = "Login", url = "users/sign_in")
public class LoginPage extends AbstractPage {

    @Locator(id = "google-modal-signin")
    private Button googleSignInButton;

    @Locator(xpath = "/html/body/div[6]/div/div[2]/form/div/input[3]")
    private Button signInButton;

    public LoginPage(Browser browser) {
        super(browser);
    }

    public Button getGoogleSignInButton() {
        return googleSignInButton;
    }

    public Button getSignInButton() {
        return signInButton;
    }
}
