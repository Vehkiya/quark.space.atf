package page.pages;

import org.openqa.selenium.WebElement;
import page.common.elements.Locator;
import page.common.pages.AbstractPage;
import page.common.pages.PageAccessor;

@PageAccessor(name = "Login", url = "/users/sign_in")
public class LoginPage extends AbstractPage {

    @Locator(name = "username", id = "user_email")
    private
    WebElement username;

    @Locator(name = "password", id = "user_password")
    private
    WebElement password;

    @Locator(name = "remember me", id = "user_remember_me")
    private
    WebElement rememberMe;

    @Locator(name = "login", xpath = "//*[@id='new_user']/div/input[3]")
    private
    WebElement login;

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getRememberMe() {
        return rememberMe;
    }

    public WebElement getLogin() {
        return login;
    }
}
