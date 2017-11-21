package page.factory;

import org.springframework.stereotype.Service;
import page.common.AbstractPage;
import page.common.Locator;

import java.lang.reflect.Field;
import java.util.Arrays;

@Service
public class PageScanner {

    public void scanPage(Class<? extends AbstractPage> pageType) {
        Field[] elementsOnPage = Arrays.stream(pageType.getDeclaredFields()).filter(field -> field.getAnnotation(Locator.class) != null).toArray(Field[]::new);

        System.out.println();
    }
}
