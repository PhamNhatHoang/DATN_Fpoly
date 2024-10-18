package com.example.petshop.config;

import com.example.petshop.service.UserServiceDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
=======
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
>>>>>>> 1ca2bf2910c223089592b9fb43660604cf8a1054
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
<<<<<<< HEAD
        http.csrf(csrf -> csrf.disable());
        http.cors(cors -> cors.disable());

        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/").permitAll();
            auth.requestMatchers("/quan-tri-he-thong").hasRole("ADMIN");
            auth.requestMatchers("/thanh-toan").authenticated();
            auth.anyRequest().permitAll();
        });
        http.formLogin(form -> {
            form.loginPage("/login").permitAll()
                    .defaultSuccessUrl("/login?success=true", true)
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

=======
        http.csrf(csrt -> csrt.disable());
        http.cors(cors -> cors.disable());
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/quan-tri-he-thong").hasRole("ADMIN")
                        .requestMatchers("/thanh-toan").authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login").permitAll()
                        .defaultSuccessUrl("/login?success=true", true)
                        .failureUrl("/login?error=true")
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                )
                .exceptionHandling(ex -> ex.accessDeniedPage("/access-denied"))
                .rememberMe(rememberMe -> rememberMe
                        .key("uniqueAndSecret")
                        .tokenValiditySeconds(86400)
                        .userDetailsService(userServiceDetails)
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }


>>>>>>> 1ca2bf2910c223089592b9fb43660604cf8a1054
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userServiceDetails);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
<<<<<<< HEAD
=======

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
>>>>>>> 1ca2bf2910c223089592b9fb43660604cf8a1054
}
