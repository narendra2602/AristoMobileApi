package com.aristomobileapi.service;

import java.util.List;

import com.aristomobileapi.request.LoginRequest;
import com.aristomobileapi.response.DataUploadMessageResponse;
import com.aristomobileapi.response.LoginResponse;
import com.aristomobileapi.response.ReportTabResponse;

public interface LoginService {
	
	LoginResponse authenticateUser(LoginRequest request);
	
	DataUploadMessageResponse getMessage(int depoCode);
	
	
	List<ReportTabResponse> getReportMenuList(int loginId);


	
}
