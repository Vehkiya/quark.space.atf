package page;

import page.common.pages.Page;
import page.common.pages.PageAccessor;
import page.pages.LoginPage;

import java.util.Arrays;
import java.util.Optional;

public enum PageType {
    LOGIN(LoginPage.class);

    Class<? extends Page> pageClass;

    PageType(final Class<? extends Page> pageClass) {
        this.pageClass = pageClass;
    }

    public Class<? extends Page> getPageClass() {
        return pageClass;
    }

    public static PageType getByPageName(String name) {
        Optional<PageType> optPage = Arrays.stream(PageType.values())
                                           .filter(pageType -> pageType.getPageClass().getAnnotation(PageAccessor.class).name().equalsIgnoreCase(name))
                                           .findFirst();
        return optPage.orElse(null);
    }
}
