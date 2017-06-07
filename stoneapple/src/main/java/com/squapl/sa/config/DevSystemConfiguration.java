package com.squapl.sa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile({"dev", "default"})
public class DevSystemConfiguration implements SystemConfiguration{
	
	
}
