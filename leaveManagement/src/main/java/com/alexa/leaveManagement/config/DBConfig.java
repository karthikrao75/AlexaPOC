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
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(environment.getProperty("sqlite.driver.class.name"));
		dataSourceBuilder.url(environment.getProperty("sqlite.url"));

		return dataSourceBuilder.build();
	}
}
