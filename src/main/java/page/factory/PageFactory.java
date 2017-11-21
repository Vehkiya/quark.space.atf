package page.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import page.common.AbstractPage;

import java.util.Properties;

@Service
public class PageFactory {

    @Autowired
    @Qualifier("webProperties")
    Properties webProperties;

    PageScanner pageScanner = new PageScanner();

    public void scanPage(Class<? extends AbstractPage> pageType) {
        pageScanner.scanPage(pageType);
    }
}
