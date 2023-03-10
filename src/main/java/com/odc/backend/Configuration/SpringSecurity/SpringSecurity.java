package com.odc.backend.Configuration.SpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.odc.backend.Configuration.SpringSecurity.Jwt.AuthTokenFilter;
import com.odc.backend.Configuration.SpringSecurity.Services.UserDetailsServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(
    prePostEnabled = true)
public class SpringSecurity {
    
    @Autowired
    UserDetailsServiceImpl userDetailsService;
  
    // @Autowired
    // private AuthEntryPointJwt unauthorizedHandler;

    
    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
            // .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
            // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
            // .antMatchers("/region/get/**").permitAll()
            // .antMatchers("/pays/get/**").permitAll()
            .antMatchers("/user/login").permitAll()
            .antMatchers("/user/signup").permitAll()
            .antMatchers("/user/getuser/**").permitAll()

            
            //.antMatchers("/user/listeCitoyen").permitAll()
            .antMatchers("/logout").permitAll()
            .antMatchers("/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**").permitAll()
            .antMatchers("/problematique/**").permitAll()

            //.antMatchers("/swagger").permitAll()
            //.antMatchers("/swagger-ui.html").permitAll()

            
            .anyRequest().authenticated();

        http.formLogin();
        // http.oauth2Login();
        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }
}
