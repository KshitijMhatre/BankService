package com.beans;

import com.utility.Date;

/**
 * @author Kshitij Mhatre
 *
 */
public class Transaction {

	private int tId;
	private String tType;
	private Date tDate;
	private float currBal;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	
	public Transaction(int tId, String tType, Date tDate, float currBal) {
		super();
		this.tId = tId;
		this.tType = tType;
		this.tDate = tDate;
		this.currBal = currBal;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettType() {
		return tType;
	}

	public void settType(String tType) {
		this.tType = tType;
	}

	public Date gettDate() {
		return tDate;
	}

	public void settDate(Date tDate) {
		this.tDate = tDate;
	}

	public float getCurrBal() {
		return currBal;
	}

	public void setCurrBal(float currBal) {
		this.currBal = currBal;
	}
	
	
	
}
