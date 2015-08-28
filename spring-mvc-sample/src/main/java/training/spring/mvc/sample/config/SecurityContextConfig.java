package training.spring.mvc.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Patrick Tan
 */
@Configuration
@EnableWebSecurity
public class SecurityContextConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("user@12345").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin@12345").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("developer").password("dev@12345").roles("DEVELOPER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/public/**").anonymous()
                .antMatchers("/secured/**").authenticated()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/developer/**").hasAnyRole("ADMIN", "DEVELOPER")
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/secured/home")
                .failureUrl("/login?error")
                .and().exceptionHandling().accessDeniedPage("/access-denied");
    }
}
