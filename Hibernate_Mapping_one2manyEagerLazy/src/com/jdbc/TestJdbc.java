package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/onetomany?useSSL=false";
		String username ="root";
		String password = "root";
		
		try {
			System.out.println("Connecting to the DB.."+jdbcUrl);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Doneee!!");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
