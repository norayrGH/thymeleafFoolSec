package am.foolSec.example.thymeleafFoolSec.security.configs;

import am.foolSec.example.thymeleafFoolSec.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").hasAnyRole("ADMIN","USER").anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login").permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/img/**", "/js/**", "/less/**", "/vendor/**");
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
