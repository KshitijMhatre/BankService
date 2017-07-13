package com.servicesImpl;

import java.sql.SQLException;

import com.beans.Account;
import com.beans.Transaction;
import com.daoServices.DaoServices;
import com.exceptions.InsufficientBalanceException;
import com.exceptions.InvalidAccountNoException;
import com.exceptions.ServiceNotAvailableException;
import com.provider.DaoProvider;
import com.services.Services;
import com.utility.Date;

/**
 * @author Kshitij Mhatre
 *
 */
public class BankServices implements Services{
	
	private Account tempAcc;
	private Transaction trans;
	private DaoServices dao;

	
	/**
	 * initialize dao handler  
	 */
	public BankServices()
	{
		// TODO Auto-generated constructor stub
		dao=DaoProvider.getDao();
	}

	//this method is to be called to open new account from client code
	/* (non-Javadoc)
	 * @see com.services.Services#openAcc(java.lang.String, float)
	 */
	@Override
	public int openAcc(String accType, float accBal) throws ServiceNotAvailableException
	{
		// TODO Auto-generated method stub
		int accNo=0;
		
		tempAcc=new Account(accType, accBal);
		try {
			dao.addAcc(accType, accBal);
			accNo=dao.getLastAccNo();
			System.out.println("Account opened successfully");
			dao.showAcc(accNo);
			
		} catch (SQLException e) {
			// wrapper exception
			throw new ServiceNotAvailableException();
			
		}
		
			
		tempAcc.setAccNo(accNo);
		
		return accNo;
	}

	//this method is used to deposit credits in account
	/* (non-Javadoc)
	 * @see com.services.Services#deposit(int, float)
	 */
	@Override
	public void deposit(int accNo, float amt) throws InvalidAccountNoException, ServiceNotAvailableException {
		// TODO Auto-generated method stub
		try {
			if(dao.checkAcc(accNo)){
			float accBal=dao.getBal(accNo);
			accBal+=amt;
			dao.updateBal(accNo, accBal);
			dao.addTrans("deposit", accBal, new Date(12, 2, 1992), accNo);
			System.out.println("Account credited current details..");
			dao.showAcc(accNo);
			}
			else{
				throw new InvalidAccountNoException();
			}
		} catch (SQLException e) {
			// wrapper exception			
			
			throw new ServiceNotAvailableException();
		}
	}

	//this method is used to withdraw amount from account	
	/* (non-Javadoc)
	 * @see com.services.Services#withdraw(int, float)
	 */
	@Override
	public void withdraw(int accNo, float amt) throws  InsufficientBalanceException, InvalidAccountNoException, ServiceNotAvailableException {
		// TODO Auto-generated method stub
		
		try {
		if(dao.checkAcc(accNo)){
			
			float accBal=dao.getBal(accNo);
			//System.out.println(accNo+" "+accBal);
				if (accBal>=amt)
				{
					accBal-=amt;
					
						dao.updateBal(accNo, accBal);
						dao.addTrans("withdraw", accBal, new Date(12, 2, 1992), accNo);
						
						System.out.println("Account debited current details..");
						dao.showAcc(accNo);
					
				}
				else
				{
					throw new InsufficientBalanceException();
				}
		}
		else{
			throw new InvalidAccountNoException();
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceNotAvailableException();
		}
	}

	//this method is called to transfer funds from accNo1 to accNo2	
	/* (non-Javadoc)
	 * @see com.services.Services#fundTransfer(int, int, float)
	 */
	@Override
	public void fundTransfer(int accNo1, int accNo2, float amt) throws  InsufficientBalanceException, InvalidAccountNoException, ServiceNotAvailableException {
		// TODO Auto-generated method stub
		this.withdraw(accNo1, amt);
		this.deposit(accNo2, amt);
		System.out.println("fund transfered current details..");
		try {
			dao.showAcc(accNo1);
			dao.showAcc(accNo1);
		} catch (SQLException e) {
			// wrapper exception
		    throw new ServiceNotAvailableException(); 
		}
		
		
	}

	//this method is used to print current balance of account	
	/* (non-Javadoc)
	 * @see com.services.Services#balEnquiry(int)
	 */
	@Override
	public void balEnquiry(int accNo) throws InvalidAccountNoException, ServiceNotAvailableException {
		// TODO Auto-generated method stub
		try {
			if(dao.checkAcc(accNo))
			System.out.println(dao.getBal(accNo));
			else{
				throw new InvalidAccountNoException();
			}
		} catch (SQLException e) {
			// wrapper exception
			throw new ServiceNotAvailableException();
		}
	}

	//this function is used to print mini-statement of given account
	/* (non-Javadoc)
	 * @see com.services.Services#miniStat(int)
	 */
	@Override
	public void miniStat(int accNo) throws  InvalidAccountNoException, ServiceNotAvailableException {
		// TODO Auto-generated method stub
		try {
			if(dao.checkAcc(accNo))
			dao.getTDetails(accNo);
			else{
				throw new InvalidAccountNoException();
			}
		} catch (SQLException e) {
			// wrapper exception
			throw new ServiceNotAvailableException();
		}
	}

	//this method used to delete account
	/* (non-Javadoc)
	 * @see com.services.Services#deleteAccount(int)
	 */
	@Override
	public void deleteAccount(int accNo) throws  InvalidAccountNoException, ServiceNotAvailableException {
		// TODO Auto-generated method stub
		try {
			dao.delAcc(accNo);			
		} catch (SQLException e) {
			// wrapper exception
			throw new ServiceNotAvailableException();
		}
	}

	//to print account details
	/* (non-Javadoc)
	 * @see com.services.Services#accDetails(int)
	 */
	@Override
	public void accDetails(int accNo) throws ServiceNotAvailableException, InvalidAccountNoException {
		// TODO Auto-generated method stub
		try {
			if(dao.checkAcc(accNo))
				dao.showAcc(accNo);
			else
				throw new InvalidAccountNoException();
		} catch (SQLException e) {
			// wrapper exception
			throw new ServiceNotAvailableException();
		}
	}

	
}
