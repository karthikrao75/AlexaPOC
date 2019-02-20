package com.alexa.leaveManagement.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	public void initialize() {
		Connection connection;
		try {
			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			/*statement.executeUpdate(
					"CREATE TABLE IF NOT EXISTS users ( user_id INT NOT NULL PRIMARY KEY, user_name VARCHAR(45) NOT NULL UNIQUE)");

			statement.executeUpdate(
					"CREATE TABLE IF NOT EXISTS leaves (leave_id INT NOT NULL PRIMARY KEY, start_date DATETIME NULL, end_date DATETIME NULL, leave_reason VARCHAR(200) NOT NULL, user_id INT NOT NULL, CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES users (user_id))");
*/
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
