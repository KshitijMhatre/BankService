package com.utility;

/**
 * @author Kshitij Mhatre
 *
 */
public class Date {

	private int dd,mm,yy;

	public int getDd() {
		return dd;
	}

	public void setDd(int dd) {
		this.dd = dd;
	}

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	public int getYy() {
		return yy;
	}

	public void setYy(int yy) {
		this.yy = yy;
	}

	public Date(int dd, int mm, int yy) {
		super();
		this.dd = dd;
		this.mm = mm;
		this.yy = yy;
	}
	
	//
	/**to convert Custom date object to java.sql.Date object
	 * @return 
	 */
	public java.sql.Date toDate()
	{
		java.sql.Date d=new java.sql.Date(dd, mm, yy);
		return d;
		
	}
	
}
