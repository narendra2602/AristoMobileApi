package com.aristomobileapi.service;

import com.aristomobileapi.response.DashBoardChartResponse;

public interface DashBoardService {
	
	DashBoardChartResponse getDashboardMainChart(int myear,int mon,int login_id,int utype);
	
	
}
