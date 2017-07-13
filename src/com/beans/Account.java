package com.beans;

/**
 * @author Kshitij Mhatre
 *
 */
public class Account {
	
	private int accNo;
	private String accType;
 	private float accBal;
	
 	
 	public Account() {
		// TODO Auto-generated constructor stub
	}
 	public Account( String accType, float accBal) {
		super();
		
		this.accType = accType;
		this.accBal = accBal;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public float getAccBal() {
		return accBal;
	}

	public void setAccBal(float accBal) {
		this.accBal = accBal;
	}	
 	
 	

}
