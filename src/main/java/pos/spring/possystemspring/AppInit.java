package pos.spring.possystemspring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pos.spring.possystemspring.config.WebAppConfig;
import pos.spring.possystemspring.config.WebAppRootConfig;


public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
