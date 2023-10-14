package com.harshita;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({"com.harshita"})
public class HarshitaConfig {

	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setSuffix(".jsp");
		
		return vr;
	}
}

