package com.aristomobileapi.service;

import com.aristomobileapi.response.ApiResponse;
import com.aristomobileapi.response.CurrentMonthYearResponse;
import com.aristomobileapi.response.DashBoardChartResponse;
import com.aristomobileapi.response.DashBoardDataResponse;

public interface DashBoardService {
	
	DashBoardChartResponse getDashboardMainChart(int myear,int mon,int login_id,int utype);
	ApiResponse<DashBoardDataResponse> getDashboardYearCombo();
	DashBoardChartResponse getDashboardLineChart(int myear,int mon,int login_id,int utype);
	CurrentMonthYearResponse getCurrentMonthYear(int loginId);
	
	
}
