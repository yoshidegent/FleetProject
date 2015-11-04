package com.realdolmen.fleet.config;

import com.realdolmen.fleet.User;
import com.realdolmen.fleet.authentication.FleetPrincipal;
import com.realdolmen.fleet.authentication.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;
import java.security.Principal;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .and()
                .rememberMe()
                    .useSecureCookie(true)
                    .and()
                .authorizeRequests()
                    .antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/scripts/**").permitAll()
                    .anyRequest().authenticated();
                /*.and()
                    .authorizeRequests()
                    .anyRequest().authenticated();*/
    }

    @Bean
    public User currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null) {
            return null;
        }

        Principal principal = (Principal)authentication.getPrincipal();
        if(!(principal instanceof FleetPrincipal)) {
            return null;
        }

        FleetPrincipal fleetPrincipal = (FleetPrincipal) principal;
        return fleetPrincipal.getUser();
    }
}
