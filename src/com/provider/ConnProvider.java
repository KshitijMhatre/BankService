package com.provider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Kshitij Mhatre 
 */
public class ConnProvider {
	
		
	static Properties p;

	static{
			
		FileInputStream fis;
		try {
			fis=new FileInputStream(".//resources//config.properties");
			p= new Properties();
			p.load(fis);
						
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	/**
	 * this function returns connection object loading the database drivers 
	 * 
	 */
	public static Connection getConnection() {
		Connection con=null;									// if done in static single connection will be shared 
		
		try {
			Class.forName(p.getProperty("driver"));				// if done in static single connection will be shared 
			con=DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
				return con;		
	}
	
}
