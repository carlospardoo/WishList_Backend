package com.carvajal.ebusiness.security;

import com.carvajal.ebusiness.service.ClientService;
import com.carvajal.ebusiness.service.impl.ClientServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter{

    @Autowired
    @Qualifier("clientServiceImpl")
    private ClientService cService;
    
    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Search for user to authenticate. Search information
     * related with an specific user.
     * Take data from a defined user service
     * @return 
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(cService);
        auth.setPasswordEncoder(passwordEncoder());
        
        return auth;
    }

    /**
     * @param 
     * Validate that user data are correct
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers( //List of routes to doing something
            //"/**",
            "/js/**",
            "/css/**",
            "/img/**"
            ).permitAll() //enable all antMatchers
        .anyRequest().authenticated() //throw a login request for any route different that routes on antMatchers
        .and() //classic and
        .formLogin() //creates a login page. If dont have route, create a default login page
        .permitAll() //enable all access to formLogin
        .and()
        .logout() //default /logout. Route for logout
        .invalidateHttpSession(true) //Invalid the current session
        .clearAuthentication(true) //clear al data related with the authenticate
        .logoutRequestMatcher(new AntPathRequestMatcher("/")) //URL to go at logout
        .logoutSuccessUrl("/logout") //add to url when logout has succesfully complete
        .permitAll();
    }

}
