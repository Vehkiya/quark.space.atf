package configuration;

import common.error.ATFException;
import context.ScenarioContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import webdriver.Browser;
import webdriver.BrowserFactory;
import webdriver.fixture.BrowserName;

import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScans({@ComponentScan("webdriver"),
                 @ComponentScan("page"),
                 @ComponentScan("configuration"),
                 @ComponentScan("actions"),
                 @ComponentScan("steps"),
                 @ComponentScan("hooks")})
public class AtfSpringConfig {

    @Bean(name = "driverProperties")
    public Properties driverProperties() throws IOException {
        Properties driverProperties = new Properties();
        driverProperties.load(getClass().getClassLoader().getResourceAsStream("properties/driver.properties"));
        return driverProperties;
    }

    @Bean(name = "webProperties")
    public Properties webProperties() throws IOException {
        Properties driverProperties = new Properties();
        driverProperties.load(getClass().getClassLoader().getResourceAsStream("properties/web.properties"));
        return driverProperties;
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer webPropertiesPlaceholder() throws IOException {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setLocation(new ClassPathResource("properties/web.properties"));
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public ScenarioContext scenarioContext() {
        return new ScenarioContext();
    }

    @Bean
    public BrowserFactory browserFactory() throws IOException {
        return new BrowserFactory(driverProperties());
    }

    @Bean
    public Browser browser() throws IOException, ATFException {
//        return browserFactory().getBrowser(BrowserName.getByDescription(webProperties().getProperty("active.browser")));

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities().phantomjs();
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                                          driverProperties().getProperty("phantomjs.binary.path"));

        WebDriver webDriver = new PhantomJSDriver(desiredCapabilities);

        return new Browser(BrowserName.HEADLESS, webDriver);
    }
}
