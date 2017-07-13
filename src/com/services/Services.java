package com.services;


import com.exceptions.InsufficientBalanceException;
import com.exceptions.InvalidAccountNoException;
import com.exceptions.ServiceNotAvailableException;

/**
 * @author Kshitij Mhatre
 *
 */
public interface Services {

	//this method is to be called to open new account from client code 
	/**
	 * @param accType
	 * @param accBal
	 * @return
	 * @throws ServiceNotAvailableException
	 */
	public int openAcc(String accType,float accBal) throws ServiceNotAvailableException;
	
	//this method is used to deposit credits in account
	/**
	 * @param accNo
	 * @param amt
	 * @throws InvalidAccountNoException
	 * @throws ServiceNotAvailableException
	 */
	public void deposit(int accNo,float amt) throws  InvalidAccountNoException, ServiceNotAvailableException;
	
	//this method is used to withdraw amount from account	
	/**
	 * @param accNo
	 * @param amt
	 * @throws InsufficientBalanceException
	 * @throws InvalidAccountNoException
	 * @throws ServiceNotAvailableException
	 */
	public void withdraw(int accNo,float amt) throws  InsufficientBalanceException, InvalidAccountNoException, ServiceNotAvailableException;
	
	//this method is called to transfer funds from accNo1 to accNo2	
	/**
	 * @param accNo1
	 * @param accNo2
	 * @param amt
	 * @throws InsufficientBalanceException
	 * @throws InvalidAccountNoException
	 * @throws ServiceNotAvailableException
	 */
	public void fundTransfer(int accNo1,int accNo2,float amt) throws InsufficientBalanceException, InvalidAccountNoException, ServiceNotAvailableException;
	
	//this method is used to print current balance of account
	/**
	 * @param accNo
	 * @throws InvalidAccountNoException
	 * @throws ServiceNotAvailableException
	 */
	public void balEnquiry(int accNo) throws  InvalidAccountNoException, ServiceNotAvailableException;
	
	//this function is used to print mini-statement of given account	
	/**
	 * @param accNo
	 * @throws InvalidAccountNoException
	 * @throws ServiceNotAvailableException
	 */
	public void miniStat(int accNo) throws  InvalidAccountNoException, ServiceNotAvailableException;
	
	//this method used to delete account
	/**
	 * @param accNo
	 * @throws InvalidAccountNoException
	 * @throws ServiceNotAvailableException
	 */
	public void deleteAccount(int accNo) throws InvalidAccountNoException, ServiceNotAvailableException;
	
	//to print account details
	public void accDetails(int accNo) throws ServiceNotAvailableException, InvalidAccountNoException;
}
