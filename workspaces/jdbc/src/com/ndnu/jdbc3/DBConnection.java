package com.ndnu.jdbc3;

import java.sql.*; 
import java.util.*;
import java.io.*;

public class DBConnection {
	private Connection conn;
	private String url;
	private String driver;
	private String login;
	private String password;

	//constructor initializes conn and pulls getConnectionInfo().
	public DBConnection() { 
		conn = null;
		getConnectionInfo();
	}

	private void getConnectionInfo() {
		Properties props = new Properties();
		try {
		   FileInputStream propsData = 
			new FileInputStream("./conf/dbconnection.props");
		   props.load(propsData);
		   propsData.close();
		} catch (IOException e) {
		  e.printStackTrace();
		  return;
		}
		
		url = props.getProperty("url");
		driver = props.getProperty("driver");
		login = props.getProperty("login");
		password = props.getProperty("password");
	}

	public Connection getConnection() {

		try {
		     Class.forName(driver).newInstance();
	             conn = DriverManager.getConnection(url, login, password);
		}catch (ClassNotFoundException e) {
	           e.printStackTrace();
	  	}catch (SQLException sqlex) {
	           sqlex.printStackTrace();
	  	}catch (Exception ex) {
	           ex.printStackTrace();
	  	}

		return conn;
	}

}
