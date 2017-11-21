package webelement;

import org.openqa.selenium.WebElement;
import webelement.common.AbstractWebElement;

public class Button extends AbstractWebElement {

    private String name;

    public Button(WebElement webElement) {
        super(webElement);
        this.name = webElement.getText();
    }

    public String getName() {
        return name;
    }
}
