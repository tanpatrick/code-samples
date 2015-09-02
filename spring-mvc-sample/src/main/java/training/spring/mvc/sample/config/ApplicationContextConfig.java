package training.spring.mvc.sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author Patrick Tan
 */
@Configuration
@ComponentScan("training.spring.*")
@Import({SecurityContextConfig.class, HibernateConfig.class})
public class ApplicationContextConfig {

    /**
     * replaced by WebAppContext.configureViewResolvers
     */
//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/WEB-INF/jsp/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }
}
