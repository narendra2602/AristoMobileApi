package com.aristomobileapi.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aristomobileapi.constant.AristoMobileLogMsgConstant;
import com.aristomobileapi.response.ApiResponse;
import com.aristomobileapi.response.CurrentMonthYearResponse;
import com.aristomobileapi.response.DashBoardChartResponse;
import com.aristomobileapi.response.DashBoardDataResponse;
import com.aristomobileapi.service.DashBoardService;
import com.aristomobileapi.utility.AppRequestParameterUtils;

@RestController
@CrossOrigin
@RequestMapping("/api/mis")
public class DashBoardController {

	Logger logger = LoggerFactory.getLogger(DashBoardController.class);
	
	@Autowired
	private DashBoardService dashBoardService;
	
	@Autowired
	private AppRequestParameterUtils appRequestParameterUtils;
	
	@GetMapping("${mrc_dashboardchart_path}")
	public ResponseEntity<DashBoardChartResponse> getDashboardMainChart(@PathVariable("myear") int myear,@PathVariable("mon") int mon,HttpServletRequest request)
	{

		
		int loginId=getLoginIdFromToken(request)[0];
        int uType=getLoginIdFromToken(request)[1];

        logger.info(AristoMobileLogMsgConstant.DASH_BOARD_CONTROLLER,"getDashboardMainChart", myear,mon,uType,loginId);
		return new ResponseEntity<DashBoardChartResponse>(dashBoardService.getDashboardMainChart(myear,mon,loginId,uType), HttpStatus.OK);
	
	}

	@GetMapping("${mrc_dashboardlinechart_path}")
	public ResponseEntity<DashBoardChartResponse> getDashboardLineChart(@PathVariable("myear") int myear,@PathVariable("mon") int mon,HttpServletRequest request)
	{

		
		int loginId=getLoginIdFromToken(request)[0];
        int uType=getLoginIdFromToken(request)[1];

        logger.info(AristoMobileLogMsgConstant.DASH_BOARD_CONTROLLER,"getDashboardLineChart", myear,mon,uType,loginId);
		return new ResponseEntity<DashBoardChartResponse>(dashBoardService.getDashboardLineChart(myear,mon,loginId,uType), HttpStatus.OK);
	
	}

	
	
	@GetMapping("${mrc_dashboardYearCombo_path}")
	public ResponseEntity<ApiResponse<DashBoardDataResponse>> getDashboardYearCombo()
	{

//		logger.info(AristoWebLogMsgConstant.DASH_BOARD_CONTROLLER,"getDashboardYearCombo");

		return new ResponseEntity<ApiResponse<DashBoardDataResponse>>(dashBoardService.getDashboardYearCombo(), HttpStatus.OK);
	
	}


	@GetMapping("${mrc_dashboardCurrentMonthYear_path}")
	public ResponseEntity<CurrentMonthYearResponse> getCurrentMonthYear(HttpServletRequest request)
	{

		int loginId=getLoginIdFromToken(request)[0];
        
		return new ResponseEntity<CurrentMonthYearResponse>(dashBoardService.getCurrentMonthYear(loginId), HttpStatus.OK);
	
	}

	
    private int[] getLoginIdFromToken(HttpServletRequest request)
    {
		String authHeader = request.getHeader("Authorization");
		int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
        return requestValues;
    }

	
}
