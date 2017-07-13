package com.provider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.services.Services;

/**
 * @author Kshitij Mhatre
 *
 */
public class BankProvider {
		
	/**	 
	 * @return
	 *	Method called to get instance of Service implementation layer as 
	 *	reference of services interface 
	 */
	public static Services getBank()
	{
		
		Services service=null;
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(".//resources//config.properties");
			Properties p=new Properties();
			p.load(fis);
			
			String serviceImp=p.getProperty("bankImp");
			Class c= Class.forName(serviceImp);
			
			//System.out.println("got class");
			service=(Services)c.newInstance();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return service;
	}
}
