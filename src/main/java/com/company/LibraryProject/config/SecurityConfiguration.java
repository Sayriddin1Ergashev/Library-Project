package com.company.LibraryProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration {


//@Autowired
    private PasswordEncoder passwordEncoder;

/*@Autowired
public void authenticationManagerBuilder(AuthenticationManagerBuilder  builder){
builder.inMemoryAuthentication()
        .withUser("User")
        .password(passwordEncoder.encode("root"))
        .roles("ADMIN")
        .and()
        .withUser("Sayriddin")
        .password(passwordEncoder.encode("root"))
        .roles("ADMIN")
        .and
        .passwordEncoder(passwordEncoder);
}*/

    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/user/**").permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin()
                .and().build();


    }*/
}
