package mbarralo.hacks.resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableResourceServer
public class ResourceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceServerApplication.class, args);
    }

}


@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .anonymous().disable()
                .authorizeRequests()
                .antMatchers("/**").authenticated();
    }

}

@RestController
@RequestMapping("ping")
class PingResource {

    @GetMapping
    public String hello() {
        return "hello world!";
    }
}
