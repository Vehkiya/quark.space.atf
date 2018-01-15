package page.factory;

import common.error.ATFException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import page.common.elements.Locator;
import page.common.pages.Page;
import webdriver.Browser;

import java.lang.reflect.Field;
import java.util.Arrays;

@Service
public class PageScanner {


    public void scanPage(Page page, Browser browser) throws ATFException {
        Field[] elementsOnPage = Arrays.stream(page.getClass().getDeclaredFields())
                                       .filter(field -> field.getAnnotation(Locator.class) != null).toArray(Field[]::new);

        for (Field field : elementsOnPage) {
            Locator locator = field.getAnnotation(Locator.class);
            WebElement webElement = browser.findElements(By.id(locator.id())).stream().findFirst().isPresent()
                                    ? browser.findElements(By.id(locator.id())).stream().filter(WebElement::isDisplayed).findFirst().orElse(null)
                                    : browser.findElement(By.xpath(locator.xpath()));
            updateFieldWithValue(field, page, webElement);
        }
    }

    private void updateFieldWithValue(Field field, Object object, Object value) throws ATFException {
        try {
            field.setAccessible(true);
            field.set(object, value);
        } catch (IllegalAccessException e) {
            throw new ATFException("Could not update field" + e.getMessage());
        }


    }
}
