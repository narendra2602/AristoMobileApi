package com.aristomobileapi.service;

import java.util.List;

import com.aristomobileapi.request.LoginRequest;
import com.aristomobileapi.response.DataUploadMessageResponse;
import com.aristomobileapi.response.LoginResponse;
import com.aristomobileapi.response.MobileVersionResponse;
import com.aristomobileapi.response.ReportTabResponse;

public interface LoginService {
	
	LoginResponse authenticateUser(LoginRequest request);
	
	DataUploadMessageResponse getMessage(int divCode,int depoCode);
	
	MobileVersionResponse getMobileVersion();
	
	List<ReportTabResponse> getReportMenuList(int loginId);


	
}
