package com.miniprojet.location_des_voitures.security;

import com.miniprojet.location_des_voitures.model.Agent;
import com.miniprojet.location_des_voitures.service.IAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService uds;
    @Autowired
    private IAgentService agentService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Bean
    public void createAgent() {
        if (!agentService.existsByIdentifiant("agent")) {
            Agent agent = new Agent();
            agent.setIdentifiant("agent");
            agent.setPassword("agent");
            agent.setNom("agent");
            agent.setPrenom("agent");
            agent.setEmail("agent@mail.com");
            agent.setTelephone("0000000000");
            agentService.createAgent(agent);
        }
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/voitures/all","/voitures/{id}/details","/voitures/all/**","/bower_components/**","/build/**","/css/**","/dist/**","/fonts/**","/images/**","/images_2/**","/js/**","/plugins/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                        // .defaultSuccessUrl("/welcome",true)
                        .successHandler(myAuthenticationSuccessHandler()))
                .logout((logout) -> logout.permitAll())
                .exceptionHandling((exceptionHandling) -> exceptionHandling
                        .accessDeniedPage("/access-denied"))
                .authenticationProvider(authenticationProvider());

        return http.build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(uds);
        authenticationProvider.setPasswordEncoder(encoder);
        return authenticationProvider;
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return new MySimpleUrlAuthenticationSuccessHandler();
    }
}

