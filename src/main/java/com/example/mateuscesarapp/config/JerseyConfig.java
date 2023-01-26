package com.example.mateuscesarapp.config;

import com.example.mateuscesarapp.service.AthleteService;
import com.example.mateuscesarapp.service.AthleteServiceImpl;
import com.example.mateuscesarapp.service.ClubService;
import com.example.mateuscesarapp.service.ClubServiceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(AthleteService.class);
        register(ClubService.class);
    }

}
