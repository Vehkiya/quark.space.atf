package page.factory;

import common.error.ATFException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import page.common.pages.AbstractPage;
import page.common.pages.Page;
import page.common.pages.PageAccessor;
import webdriver.Browser;
import webdriver.BrowserFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static webdriver.fixture.BrowserName.HEADLESS;

@Service
public class PageFactory {

    @Autowired
    private PageScanner pageScanner;

    @Autowired
    private BrowserFactory browserFactory;

    private Browser browser;

    public Page getPage(Class<? extends Page> pageClass) throws ATFException {
        browser = browserFactory.getBrowser(HEADLESS);
        try {
            Constructor constructor = pageClass.getConstructors()[0];
            constructor.setAccessible(true);
            Page page = (Page) constructor.newInstance();
            browser.get(page.getClass().getAnnotation(PageAccessor.class).url());
            updatePageDetails(page);
            pageScanner.scanPage(page, browser);

            return page;
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new ATFException(e.getMessage());
        }
    }

    private void updatePageDetails(Page page) {
        AbstractPage abstractPage = (AbstractPage) page;
        abstractPage.setBrowser(browser);
        abstractPage.setPageName(page.getClass().getAnnotation(PageAccessor.class).name());
        abstractPage.setUrl(browser.getCurrentUrl());

    }
}
