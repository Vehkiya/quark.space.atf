package configuration;

import context.ScenarioContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScans({
        @ComponentScan("webdriver"),
        @ComponentScan("page"),
        @ComponentScan("configuration"),
        @ComponentScan("actions"),
        @ComponentScan("steps")})
public class SpringConfig {

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
}
