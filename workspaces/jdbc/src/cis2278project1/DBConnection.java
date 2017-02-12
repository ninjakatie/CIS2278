package cis2278project1;
import java.sql.*;
import java.util.*;
import java.io.*;
/**
*
* Reusing Rolly's code to save time.  
*/

//this class creates a connection object by using the properties object.

public class DBConnection {
	private Connection connection;
	private Statement statement;
	private String url;
	private String driver;
	private String login;
	private String password;
    
	public DBConnection() {
        connection = null;
		statement = null;
		getConnectionInfo();
    }
    
	//instantiating a new properties object and loading the propsData into it.
	private void getConnectionInfo() {
		Properties props = new Properties(); 
		try {
		   FileInputStream propsData = new FileInputStream("./conf/dbconnection.props");	
           props.load(propsData); 
		   propsData.close();
		} catch (IOException e) {
		  e.printStackTrace();
		  return;
		}
		// initializing class variables with the properties from connection access properties from the props file. 
		url = props.getProperty("url");
		driver = props.getProperty("driver");
		login = props.getProperty("login");
		password = props.getProperty("password");
	}

	public Connection getConnection() { //this method returns a reference to the Connection object.
		try {
		     Class.forName(driver).newInstance();
	             connection = DriverManager.getConnection(url, login, password);
		}catch (ClassNotFoundException e) {
	           e.printStackTrace();
	  	}catch (SQLException sqlex) {
	           sqlex.printStackTrace();
	  	}catch (Exception ex) {
	           ex.printStackTrace();
	  	}
		return connection;
	}
}
