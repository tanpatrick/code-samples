package training.spring.mvc.sample.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.text.SimpleDateFormat;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    private static final Logger LOGGER = Logger.getLogger(WebMvcConfiguration.class);

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        LOGGER.debug("configure message converters ...");

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setDateFormat(new SimpleDateFormat("MMM/dd/yyyy"));
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Hibernate4Module hibernate4Module = new Hibernate4Module();
        hibernate4Module.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);
        objectMapper.registerModule(hibernate4Module);

        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setObjectMapper(objectMapper);
        converters.add(jsonConverter);

        super.configureMessageConverters(converters);
    }

}
