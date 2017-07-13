package com.daoServices;

import java.sql.SQLException;

import com.exceptions.InvalidAccountNoException;

/**
 * @author Kshitij Mhatre
 *
 */
public interface DaoServices {

	//to add record to account table	
	/**
	 * @param accType
	 * @param accBal
	 * @throws SQLException
	 */
	public void addAcc(String accType,float accBal) throws SQLException;
	
	//to update balance of account
	/**
	 * @param accNo
	 * @param accBal
	 * @throws SQLException
	 */
	public void updateBal(int accNo,float accBal) throws SQLException;
	
	//to retrive balance in account
	/**
	 * @param accNo
	 * @return balance
	 * @throws SQLException
	 */
	public float getBal(int accNo) throws SQLException;
	
	//method to delete account
	/**
	 * @param accNo
	 * @throws SQLException 
	 * @throws InvalidAccountNoException 
	 */
	public void delAcc(int accNo) throws SQLException, InvalidAccountNoException;
	
	//method to retrieve last auto-generated accNo
	/**
	 * @return
	 * @throws SQLException
	 */
	public int getLastAccNo() throws SQLException;
	
	//to check if account exists
	/**
	 * @param accNo
	 * @return
	 * @throws SQLException
	 */
	public boolean checkAcc(int accNo) throws SQLException;
	
	//to print transactions of given account
	/**
	 * @param accNo
	 * @throws SQLException
	 */
	public void getTDetails(int accNo) throws SQLException;
	
	//add transaction to transaction table
	/**
	 * @param ttype
	 * @param currBal
	 * @param tDate
	 * @param accNo
	 * @throws SQLException
	 */
	public void addTrans(String ttype,float currBal,com.utility.Date tDate,int accNo) throws SQLException;
	
	//to view account details	
	/**
	 * @param accNo
	 * @throws SQLException
	 */
	public void showAcc(int accNo) throws SQLException;
	
}
