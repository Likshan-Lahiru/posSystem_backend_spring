package pos.spring.possystemspring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "pos.spring.possystemspring")
@EnableWebMvc
public class WebAppConfig {
}

