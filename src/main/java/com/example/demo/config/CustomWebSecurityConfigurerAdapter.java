package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

    @Value("${credentials.admin.login}")
    private String adminLogin;
    @Value("${credentials.admin.password}")
    private String adminPassword;

    @Value("${credentials.user.login}")
    private String userLogin;
    @Value("${credentials.user.password}")
    private String userPassword;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser(userLogin)
                .password(passwordEncoder().encode(userPassword)).roles("USER")
                .and().withUser(adminLogin)
                .password(passwordEncoder().encode(adminPassword)).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/classifications").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/classifications/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/classifications/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/classifications/*/ads")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/classifications/*/ads/*")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/classifications/*/ads/*")
                .hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
