package mbarralo.hacks.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableAuthorizationServer
@EnableAutoConfiguration
@EnableResourceServer
@RestController
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

    @GetMapping
    @RequestMapping("user")
    public OAuth2Authentication user(OAuth2Authentication authentication) {
   /*     Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("username", authentication.getUserAuthentication().getName());

        ArrayList<String> authorities = new ArrayList<>();
        for (GrantedAuthority grantedAuthority : authentication.getUserAuthentication().getAuthorities()) {
            authorities.add(grantedAuthority.getAuthority());
        }

        userInfo.put("authorities", authorities);

        return userInfo; */
      return authentication;
    }
}


@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");
    }

}


