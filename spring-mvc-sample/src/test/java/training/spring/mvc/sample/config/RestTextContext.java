package training.spring.mvc.sample.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import training.spring.mvc.sample.service.BasicService;

/**
 *
 * @author Patrick Tan
 */
@Configuration
@ComponentScan("training.spring.mvc.sample.rest")
public class RestTextContext {

    @Bean
    public BasicService basicServiceMock() {
        return Mockito.mock(BasicService.class);
    }
}
