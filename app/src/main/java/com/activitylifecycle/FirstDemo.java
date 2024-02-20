package com.activitylifecycle;

import java.sql.*;

public class FirstDemo{
	static final String DB_URL = "jdbc:mysql://localhost/drinks";
	static final String USER = "root";
	static final String PASS = "admin";
	static final String QUERY = "SELECT * FROM sdrinks";
	
	public static void main(String[] args) {
		// Open a connection
		/*try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e1){e1.printStackTrace();}*/
			
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);){
			
			// Extract data from result set
			while (rs.next()){
				// Retrieve by column name
				System.out.print("ID: " + rs.getInt("drinkcode"));
				System.out.print(", Age: " + rs.getInt("drinkname"));
				System.out.print(", First: " + rs.getString("price"));
				System.out.println(", Last: " + rs.getString("calories"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}