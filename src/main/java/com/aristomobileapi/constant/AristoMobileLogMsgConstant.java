package com.aristomobileapi.constant;

public class AristoMobileLogMsgConstant {
	
	private AristoMobileLogMsgConstant()
	{
		
	}

	public static final String LOGIN_CONTROLLER="LoginController {} method execution started";
	public static final String LOGIN_SERVICE="LoginServiceImpl:: {} method execution started";
	
	
	
	public static final String DASH_BOARD_CONTROLLER="DashBoardController:: {} method execution started, myear : {}, month: {}, login_id: {} , user_type: {} ";
	
	public static final String MOBILE_DIVISION_CONTROLLER="MobileDivController:: {} method execution started, myear : {}, month: {}, login_id: {} , user_type: {} ";
	public static final String MOBILE_REPORT_DIVISION="MobileServiceImpl:: {} method execution started";


	public static final String MOBILE_BRANCH_CONTROLLER="MobileBranchController:: {} method execution started, myear : {}, month: {}, login_id: {} , user_type: {}, division: {} ";
	public static final String MOBILE_REPORT_BRANCH="MobileServiceImpl:: {} method execution started";

	
	public static final String MOBILE_HQ_CONTROLLER="MobileHQController:: {} method execution started, myear : {}, month: {}, login_id: {} , user_type: {}, division: {}, depo: {} ";
	public static final String MOBILE_REPORT_HQ="MobileServiceImpl:: {} method execution started";

	public static final String MOBILE_STK_CONTROLLER="MobileSTKController:: {} method execution started, myear : {}, month: {}, login_id: {} , user_type: {}, division: {}, depo: {}, hq_code: {} ";
	public static final String MOBILE_REPORT_STK="MobileServiceImpl:: {} method execution started";
	
	public static final String MOBILE_GROUP_CONTROLLER="MobileGroupController:: {} method execution started, myear : {}, month: {}, login_id: {} , user_type: {}, division: {}, depo: {}, hq_code: {} ";
	public static final String MOBILE_REPORT_GROUP="MobileServiceImpl:: {} method execution started";

	public static final String MOBILE_PRODUCT_CONTROLLER="MobileProductController:: {} method execution started, myear : {}, month: {}, login_id: {} , user_type: {}, division: {}, depo: {}, hq_code: {} ";
	public static final String MOBILE_REPORT_PRODUCT="MobileServiceImpl:: {} method execution started";

}
