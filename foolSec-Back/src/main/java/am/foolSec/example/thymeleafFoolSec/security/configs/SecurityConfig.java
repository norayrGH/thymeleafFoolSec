package am.foolSec.example.thymeleafFoolSec.security.configs;

import am.foolSec.example.thymeleafFoolSec.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
@CrossOrigin("http://localhost:8080/")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/signup").permitAll()
                .antMatchers("/**").hasAnyRole("ADMIN","USER").anyRequest().permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .and()
                .logout().logoutSuccessUrl("/login").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
       /* auth.inMemoryAuthentication()
                .withUser("norayrgh@qwe").password("$2a$10$Z5lOtENayPAPn5CbGw27SuDbsxkXc3x474W8SOLlbtaHP09FTiV.m").roles("ADMIN")
                .and()
                .withUser("norayrgh@asd").password("$2a$10$Z5lOtENayPAPn5CbGw27SuDbsxkXc3x474W8SOLlbtaHP09FTiV.m").roles("USER");*/
    }
}
