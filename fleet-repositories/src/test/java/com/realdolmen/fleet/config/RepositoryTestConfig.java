package com.realdolmen.fleet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan
@Profile("test")
public class RepositoryTestConfig {
}
