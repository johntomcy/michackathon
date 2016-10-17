package com.michackathon.api.config;

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
 * Created by Tomasz Kucharzyk
 */
@Configuration
@EnableResourceServer
@EnableWebSecurity
public class SecurityConfig implements ResourceServerConfigurer {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("michackathon-api");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

    }



}

