package com.aristomobileapi.dto;

import java.util.Date;

public interface Despatch {
	
	public String getMac_code();
	public String getMac_name();
	public String getMcity();
	public String  getIno();
	public String getInv_date();
	public String getOrder_no();
	public Date getDispatch_date();
	public String getMtr_no();
	public String getMtr_dt();
	public double getBill_amt();
	public String getTrasnport();
	public int getCases();
	public Date getOrder_dt();
	public int getTyp();

}
