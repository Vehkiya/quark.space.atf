package webdriver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan("webdriver")
public class DriverConfig {

    @Bean(name = "driverProperties")
    public Properties properties() throws IOException {
        Properties driverProperties = new Properties();
        driverProperties.load(getClass().getClassLoader().getResourceAsStream("properties/driver.properties"));
        return driverProperties;
    }
}
