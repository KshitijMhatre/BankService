package com.daoServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.daoServices.DaoServices;
import com.exceptions.InvalidAccountNoException;
import com.provider.ConnProvider;


/**
 * @author Kshitij Mhatre
 *
 */
public class DaoServiceImpl implements DaoServices{

	private Connection con;
	private PreparedStatement pstat;
	private ResultSet rs;
	private int ucount;
	
	//initialize connection object	
	/**
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public DaoServiceImpl() throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated constructor stub
		con=ConnProvider.getConnection();
	}
	
	//to add record to account table
	/* (non-Javadoc)
	 * @see com.daoServices.DaoServices#addAcc(java.lang.String, float)
	 */
	@Override
	public void addAcc(String accType, float accBal) throws SQLException {
		// TODO Auto-generated method stub
		pstat=con.prepareStatement("insert into Accounts values(seq_account.nextval,?,?)");	
		pstat.setString(1, accType);
		pstat.setFloat(2, accBal);		
		pstat.execute();
		
		
	}

	//to update balance of account
	/* (non-Javadoc)
	 * @see com.daoServices.DaoServices#updateBal(int, float)
	 */
	@Override
	public void updateBal(int accNo, float accBal) throws SQLException {
		// TODO Auto-generated method stub
		pstat=con.prepareStatement("update Accounts set accBal=? where accNo=?");	
		pstat.setFloat(1, accBal);
		pstat.setFloat(2, accNo);		
		pstat.execute();
		
	}
	
	//to retrive balance in account
	/* (non-Javadoc)
	 * @see com.daoServices.DaoServices#getBal(int)
	 */
	@Override
	public float getBal(int accNo) throws SQLException {
		// TODO Auto-generated method stub
		float bal=0;
		
		pstat=con.prepareStatement("select accBal from accounts where accNo=?");		
		pstat.setInt(1, accNo);		
		rs=pstat.executeQuery();
		
		rs.next();
		bal=rs.getFloat(1);
		
		return bal;
	}

	//method to delete account
	/* (non-Javadoc)
	 * @see com.daoServices.DaoServices#delAcc(int)
	 */
	@Override
	public void delAcc(int accNo) throws SQLException, InvalidAccountNoException {
		
		if(checkAcc(accNo))
		{
			pstat=con.prepareStatement("delete from transactions where accNo=?");
			pstat.setInt(1, accNo);	
			ucount=pstat.executeUpdate();
			
			
			pstat=con.prepareStatement("delete from accounts where accNo=?");
			pstat.setInt(1, accNo);	
			ucount=pstat.executeUpdate();
		
			if(ucount>0)
				System.out.println("Account deleted succesfully");
		}
		else 
			throw new InvalidAccountNoException();
	}

	//to print transactions of given account
	/* (non-Javadoc)
	 * @see com.daoServices.DaoServices#getTDetails(int)
	 */
	@Override
	public void getTDetails(int accNo) throws SQLException {
		// TODO Auto-generated method stub
		pstat=con.prepareStatement("select * from transactions where accNo=?");			
		pstat.setFloat(1, accNo);		
		rs=pstat.executeQuery();
		
		int tid;
		Date d;
		String ttype;
		float currBal;
		
		
		while(rs.next())
		{
			tid=rs.getInt(1);
			ttype=rs.getString(2);
			d=rs.getDate(3);
			currBal=rs.getFloat(4);			
			System.out.println(tid+" "+ttype+" "+d+" "+currBal);
		}
		
			System.out.println("End of transactions");
		
	}

	//add transaction to transaction table
	/* (non-Javadoc)
	 * @see com.daoServices.DaoServices#addTrans(java.lang.String, float, com.utility.Date, int)
	 */
	@Override
	public void addTrans(String ttype, float currBal,com.utility.Date tDate,int accNo) throws SQLException {
		// TODO Auto-generated method stub
		
		java.sql.Date d=tDate.toDate();
		
		pstat=con.prepareStatement("insert into transactions values(seq_transaction.nextval,?,?,?,?)");	
		pstat.setString(1, ttype);
		pstat.setDate(2, d);
		pstat.setFloat(3, currBal);
		pstat.setInt(4, accNo);
		pstat.execute();
	}

	//method to retrieve last auto-generated accNo
	/* (non-Javadoc)
	 * @see com.daoServices.DaoServices#getLastAccNo()
	 */
	@Override
	public int getLastAccNo() throws SQLException {
		// TODO Auto-generated method stub
		int accNo=0;
		
		pstat=con.prepareStatement("select max(accNo) from accounts");	
		
		rs=pstat.executeQuery();
		rs.next();
		accNo=rs.getInt(1);
		
		return accNo;
	}

	//to check if account exists
	/* (non-Javadoc)
	 * @see com.daoServices.DaoServices#checkAcc(int)
	 */
	@Override
	public boolean checkAcc(int accNo) throws SQLException {
		 //TODO Auto-generated method stub
		boolean flag=false;
		
		pstat=con.prepareStatement("select * from Accounts where accNo=?");
		pstat.setInt(1, accNo);
		rs=pstat.executeQuery();
		
		if(rs.next())
			flag=true;
		
		return flag;
	}

	//to print account details	
	/* (non-Javadoc)
	 * @see com.daoServices.DaoServices#showAcc(int)
	 */
	@Override
	public void showAcc(int accNo) throws SQLException {
		// TODO Auto-generated method stub
		pstat=con.prepareStatement("select * from accounts where accNo=?");
		pstat.setInt(1, accNo);
		
		rs=pstat.executeQuery();
		while(rs.next())
		{
			System.out.println("accNo:"+rs.getInt(1)+" accType "+rs.getString(2)+" accBal "+rs.getFloat(3));
		}
	}
	
	

}
