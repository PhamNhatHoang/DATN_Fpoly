package com.controller.config;

import com.controller.service.UserServiceDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserServiceDetails userServiceDetails;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.cors(cors -> cors.disable());

        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/", "/trang-chu", "/home").permitAll();
            auth.anyRequest().permitAll();
        });
        http.formLogin(form -> {
            form.loginPage("/login").permitAll()
                    .defaultSuccessUrl("/", true)
                    .failureUrl("/login?error=true");
        });
        http.logout(logout -> {
            logout.logoutSuccessUrl("/login").invalidateHttpSession(true).deleteCookies("JSESSIONID");
        });
        http.exceptionHandling(ex -> {
            ex.accessDeniedPage("/access-denied");
        });
        http.rememberMe(rememberMe -> {
            rememberMe.key("uniqueAndSecret").tokenValiditySeconds(86400).userDetailsService(userServiceDetails);
        });
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userServiceDetails);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
