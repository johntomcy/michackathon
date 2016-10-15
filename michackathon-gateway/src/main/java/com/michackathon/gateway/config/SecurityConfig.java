package com.shardis.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

/**
 * Created by Tarun Sukhu
 */
@Configuration
@EnableResourceServer
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SecurityConfig implements ResourceServerConfigurer {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("shardis-gateway");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .anonymous()
            .and()
            .authorizeRequests()
            .antMatchers("/api/**").permitAll()
            .antMatchers("/test").authenticated()

            .antMatchers("/actuator").permitAll()
            .antMatchers("/autoconfig").permitAll()
            .antMatchers("/beans").permitAll()
            .antMatchers("/configprops").permitAll()
            .antMatchers("/dump").permitAll()
            .antMatchers("/env").permitAll()
            .antMatchers("/flyway").permitAll()
            .antMatchers("/health").permitAll()
            .antMatchers("/info").permitAll()
            .antMatchers("/liquibase").permitAll()
            .antMatchers("/metrics").permitAll()
            .antMatchers("/mappings").permitAll()
            .antMatchers("/shutdown").denyAll()
            .antMatchers("/trace").permitAll()
            .antMatchers("/docs").permitAll()
            .antMatchers("/heapdump").permitAll()
            .antMatchers("/jolokia").permitAll()
            .antMatchers("/logfile").permitAll()

            .anyRequest().permitAll()
            .and()
            .csrf().disable()
            .exceptionHandling()
            .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
            .and()
            .logout().logoutUrl("/logout").logoutSuccessUrl("/");
    }


}

