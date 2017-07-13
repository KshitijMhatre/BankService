package com.provider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.daoServices.DaoServices;


/**
 * @author Kshitij Mhatre
 *
 */
public class DaoProvider {

	
	/**
	 * this method returns instance of Dao Implementation as refrence of Dao 
	 * services
	 * @return
	 */
	
	public static DaoServices getDao()
	{
		
		DaoServices service=null;
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(".//resources//config.properties");
			Properties p=new Properties();
			p.load(fis);
			
			String serviceImp=p.getProperty("daoImp");
			Class c= Class.forName(serviceImp);
			
			//System.out.println("got class");
			service=(DaoServices)c.newInstance();

			
			
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
