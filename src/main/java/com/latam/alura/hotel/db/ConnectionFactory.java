package com.latam.alura.hotel.db;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public java.sql.Connection getConnection() throws SQLException {
		java.sql.Connection connection = DriverManager.getConnection(
						"jdbc:mysql://localhost/db_alura?useTimezone=true&serverTimezone=UTC",
						"root",
						"root"
		);

		connection.close();
	}
}
