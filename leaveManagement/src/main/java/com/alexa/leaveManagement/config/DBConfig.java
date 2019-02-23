package com.alexa.leaveManagement.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DBConfig {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create().driverClassName(environment.getProperty("sqlite.driver.class.name"))
				.url(environment.getProperty("sqlite.url")).build();
	}
}
