

package com.ndnu.jdbc2;
import java.sql.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author Rolly
 */

//this class creates a connection object by using the properties object.

public class DBConnection {
	private Connection conn;
	private Statement stmt;
	private String url;
	private String driver;
	private String login;
	private String password;
    /** Creates a new instance of DBConnection */
    public DBConnection() {
        	conn = null;
		stmt = null;
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

	public Connection getConnection() { //this method returns a reference to the Connection object, not the object itself.

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
