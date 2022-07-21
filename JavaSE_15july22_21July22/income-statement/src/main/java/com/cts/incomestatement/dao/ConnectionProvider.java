package com.cts.incomestatement.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {

	private static ConnectionProvider instance;
	
	private String dbUrl;
	private String dbUid;
	private String dbPwd;
	
	private ConnectionProvider() throws IOException {
		Properties props = new Properties();
		props.load(new FileInputStream("dbconfig.properties"));
		this.dbUrl=props.getProperty("db.url");
		this.dbUid=props.getProperty("db.uid");
		this.dbPwd=props.getProperty("db.pwd");
	}
	
	public static ConnectionProvider getInstance() throws IOException {
		if(instance==null) {
			instance = new ConnectionProvider();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl, dbUid, dbPwd);
	}
}
