package com.cg.fms.RepoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionData {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/sakila2";
	final String USER_NAME="root";
	final String PASSWORD = "password";
	Connection con = null;
	public Connection ConnectionDataBase() throws ClassNotFoundException, SQLException{
		Class.forName(JDBC_DRIVER);
		con = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
		return con;
	}
	public void closeConnection() throws SQLException{
		con.close();
	}
}
