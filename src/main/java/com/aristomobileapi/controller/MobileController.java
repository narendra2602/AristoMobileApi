package com.aristomobileapi.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aristomobileapi.constant.AristoMobileLogMsgConstant;
import com.aristomobileapi.request.BranchRequest;
import com.aristomobileapi.request.DivisionRequest;
import com.aristomobileapi.request.GroupRequest;
import com.aristomobileapi.request.HqRequest;
import com.aristomobileapi.request.ProductRequest;
import com.aristomobileapi.request.StockiestDetailRequest;
import com.aristomobileapi.request.StockiestRequest;
import com.aristomobileapi.response.ApiResponse;
import com.aristomobileapi.response.DespatchResponse;
import com.aristomobileapi.response.MobileDespatchResponse;
import com.aristomobileapi.response.MobileDespatchStockiestResponse;
import com.aristomobileapi.response.MobileGroupResponse;
import com.aristomobileapi.response.MobilePendingResponse;
import com.aristomobileapi.response.MobilePendingStockiestResponse;
import com.aristomobileapi.response.MobileProductResponse;
import com.aristomobileapi.response.MobileSalesResponse;
import com.aristomobileapi.response.MobileStockiestResponse;
import com.aristomobileapi.service.MobileService;
import com.aristomobileapi.utility.AppRequestParameterUtils;

@RestController
@CrossOrigin
@RequestMapping("${mrc_base_path}")

public class MobileController {

	Logger logger = LoggerFactory.getLogger(MobileController.class);
	
	@Autowired
	private AppRequestParameterUtils appRequestParameterUtils;

	
	@Autowired
	private MobileService mobileService;
	
	@GetMapping("${mrc_division_path}")
	public ResponseEntity<ApiResponse<MobileSalesResponse>> getDivision(@RequestBody DivisionRequest request,HttpServletRequest req)
	{
		

        int loginId=getLoginIdFromToken(req)[0];
        int uType=getLoginIdFromToken(req)[1];

        request.setLoginId(loginId);
        request.setUtype(uType);
        
        logger.info(AristoMobileLogMsgConstant.MOBILE_DIVISION_CONTROLLER,"getDivision",request.getMyear(),request.getMonth(),loginId,uType);
		return new ResponseEntity<ApiResponse<MobileSalesResponse>>(mobileService.getDivision(request), HttpStatus.OK);
	
	}

	@GetMapping("${mrc_despatch_div_path}")
	public ResponseEntity<ApiResponse<MobileDespatchResponse>> getDespatchDivision(@RequestBody DivisionRequest request,HttpServletRequest req)
	{
		

        int loginId=getLoginIdFromToken(req)[0];
        int uType=getLoginIdFromToken(req)[1];

        request.setLoginId(loginId);
        request.setUtype(uType);
        
        logger.info(AristoMobileLogMsgConstant.MOBILE_DIVISION_CONTROLLER,"getDespatchDivision",request.getMyear(),request.getMonth(),loginId,uType);
		return new ResponseEntity<ApiResponse<MobileDespatchResponse>>(mobileService.getDespatchDivision(request), HttpStatus.OK);
	
	}

	@GetMapping("${mrc_pending_div_path}")
	public ResponseEntity<ApiResponse<MobilePendingResponse>> getPendingDivision(@RequestBody DivisionRequest request,HttpServletRequest req)
	{
		

        int loginId=getLoginIdFromToken(req)[0];
        int uType=getLoginIdFromToken(req)[1];

        request.setLoginId(loginId);
        request.setUtype(uType);
        
        logger.info(AristoMobileLogMsgConstant.MOBILE_DIVISION_CONTROLLER,"getPendingDivision",request.getMyear(),request.getMonth(),loginId,uType);
		return new ResponseEntity<ApiResponse<MobilePendingResponse>>(mobileService.getPendingDivision(request), HttpStatus.OK);
	
	}

	
	@GetMapping("${mrc_branch_path}")
	public ResponseEntity<ApiResponse<MobileSalesResponse>> getBranch(@RequestBody BranchRequest request,HttpServletRequest req)
	{
		

        int loginId=getLoginIdFromToken(req)[0];
        int uType=getLoginIdFromToken(req)[1];

        request.setLoginId(loginId);
        request.setUtype(uType);
        
        logger.info(AristoMobileLogMsgConstant.MOBILE_BRANCH_CONTROLLER,"getBranch",request.getMyear(),request.getMonth(),loginId,uType,request.getDivCode());
		return new ResponseEntity<ApiResponse<MobileSalesResponse>>(mobileService.getBranch(request), HttpStatus.OK);
	
	}

	@GetMapping("${mrc_despatch_branch_path}")
	public ResponseEntity<ApiResponse<MobileDespatchResponse>> getDespatchBranch(@RequestBody BranchRequest request,HttpServletRequest req)
	{
		

        int loginId=getLoginIdFromToken(req)[0];
        int uType=getLoginIdFromToken(req)[1];

        request.setLoginId(loginId);
        request.setUtype(uType);
        
        logger.info(AristoMobileLogMsgConstant.MOBILE_BRANCH_CONTROLLER,"getDespatchBranch",request.getMyear(),request.getMonth(),loginId,uType,request.getDivCode());
		return new ResponseEntity<ApiResponse<MobileDespatchResponse>>(mobileService.getDespatchBranch(request), HttpStatus.OK);
	
	}
	@GetMapping("${mrc_pending_branch_path}")
	public ResponseEntity<ApiResponse<MobilePendingResponse>> getPendingBranch(@RequestBody BranchRequest request,HttpServletRequest req)
	{
		

        int loginId=getLoginIdFromToken(req)[0];
        int uType=getLoginIdFromToken(req)[1];

        request.setLoginId(loginId);
        request.setUtype(uType);
        
        logger.info(AristoMobileLogMsgConstant.MOBILE_BRANCH_CONTROLLER,"getPendingBranch",request.getMyear(),request.getMonth(),loginId,uType,request.getDivCode());
		return new ResponseEntity<ApiResponse<MobilePendingResponse>>(mobileService.getPendingBranch(request), HttpStatus.OK);
	
	}

	
	@GetMapping("${mrc_hq_path}")
	public ResponseEntity<ApiResponse<MobileSalesResponse>> getHq(@RequestBody HqRequest request,HttpServletRequest req)
	{
		

        int loginId=getLoginIdFromToken(req)[0];
        int uType=getLoginIdFromToken(req)[1];

        request.setLoginId(loginId);
        request.setUtype(uType);
        
        logger.info(AristoMobileLogMsgConstant.MOBILE_HQ_CONTROLLER,"getHq",request.getMyear(),request.getMonth(),loginId,uType,request.getDivCode(),request.getDepoCode());
		return new ResponseEntity<ApiResponse<MobileSalesResponse>>(mobileService.getHq(request), HttpStatus.OK);
	
	}
	
	@GetMapping("${mrc_despatch_hq_path}")
	public ResponseEntity<ApiResponse<MobileDespatchResponse>> getDespatchHq(@RequestBody HqRequest request,HttpServletRequest req)
	{
		

        int loginId=getLoginIdFromToken(req)[0];
        int uType=getLoginIdFromToken(req)[1];

        request.setLoginId(loginId);
        request.setUtype(uType);
        
        logger.info(AristoMobileLogMsgConstant.MOBILE_HQ_CONTROLLER,"getDespatchHq",request.getMyear(),request.getMonth(),loginId,uType,request.getDivCode(),request.getDepoCode());
		return new ResponseEntity<ApiResponse<MobileDespatchResponse>>(mobileService.getDespatchHq(request), HttpStatus.OK);
	
	}
	@GetMapping("${mrc_pending_hq_path}")
	public ResponseEntity<ApiResponse<MobilePendingResponse>> getPendingHq(@RequestBody HqRequest request,HttpServletRequest req)
	{
		

        int loginId=getLoginIdFromToken(req)[0];
        int uType=getLoginIdFromToken(req)[1];

        request.setLoginId(loginId);
        request.setUtype(uType);
        
        logger.info(AristoMobileLogMsgConstant.MOBILE_HQ_CONTROLLER,"getPendingHq",request.getMyear(),request.getMonth(),loginId,uType,request.getDivCode(),request.getDepoCode());
		return new ResponseEntity<ApiResponse<MobilePendingResponse>>(mobileService.getPendingHq(request), HttpStatus.OK);
	
	}

	
	@GetMapping("${mrc_stockiest_path}")
	public ResponseEntity<ApiResponse<MobileStockiestResponse>> getStockiest(@RequestBody StockiestRequest request,HttpServletRequest req)
	{
		
        logger.info(AristoMobileLogMsgConstant.MOBILE_STK_CONTROLLER,"getStockiest",request.getMyear(),request.getMonth(),request.getDivCode(),request.getDepoCode(),request.getHqCode());
		return new ResponseEntity<ApiResponse<MobileStockiestResponse>>(mobileService.getStockiest(request), HttpStatus.OK);
	
	}

	@GetMapping("${mrc_despatch_stockiest_path}")
	public ResponseEntity<ApiResponse<MobileDespatchStockiestResponse>> getDespatchStockiest(@RequestBody StockiestRequest request,HttpServletRequest req)
	{
		
        logger.info(AristoMobileLogMsgConstant.MOBILE_STK_CONTROLLER,"getDespatchStockiest",request.getMyear(),request.getMonth(),request.getDivCode(),request.getDepoCode(),request.getHqCode());
		return new ResponseEntity<ApiResponse<MobileDespatchStockiestResponse>>(mobileService.getDespatchStockiest(request), HttpStatus.OK);
	
	}

	@GetMapping("${mrc_pending_stockiest_path}")
	public ResponseEntity<ApiResponse<MobilePendingStockiestResponse>> getPendingStockiest(@RequestBody StockiestRequest request,HttpServletRequest req)
	{
		
        logger.info(AristoMobileLogMsgConstant.MOBILE_STK_CONTROLLER,"getPendingStockiest",request.getMyear(),request.getMonth(),request.getDivCode(),request.getDepoCode(),request.getHqCode());
		return new ResponseEntity<ApiResponse<MobilePendingStockiestResponse>>(mobileService.getPendingStockiest(request), HttpStatus.OK);
	
	}

	@GetMapping("${mrc_despatch_detail_path}")
	public ResponseEntity<ApiResponse<DespatchResponse>> getDespatchDetail(@RequestBody StockiestDetailRequest request,HttpServletRequest req)
	{
		
        logger.info(AristoMobileLogMsgConstant.MOBILE_STK_CONTROLLER,"getDespatchDetail",request.getMyear(),request.getMonth(),request.getDivCode(),request.getDepoCode(),request.getPartyCode());
		return new ResponseEntity<ApiResponse<DespatchResponse>>(mobileService.getDespatchDetail(request), HttpStatus.OK);
	
	}

	@GetMapping("${mrc_group_path}")
	public ResponseEntity<ApiResponse<MobileGroupResponse>> getGroups(@RequestBody GroupRequest request,HttpServletRequest req)
	{
		
        logger.info(AristoMobileLogMsgConstant.MOBILE_GROUP_CONTROLLER,"getGroups",request.getMyear(),request.getMonth(),request.getDivCode(),request.getDepoCode(),request.getHqCode());
		return new ResponseEntity<ApiResponse<MobileGroupResponse>>(mobileService.getGroups(request), HttpStatus.OK);
	
	}

	@GetMapping("${mrc_product_path}")
	public ResponseEntity<ApiResponse<MobileProductResponse>> getProducts(@RequestBody ProductRequest request,HttpServletRequest req)
	{
		
        logger.info(AristoMobileLogMsgConstant.MOBILE_PRODUCT_CONTROLLER,"getProducts",request.getMyear(),request.getMonth(),request.getDivCode(),request.getDepoCode(),request.getHqCode());
		return new ResponseEntity<ApiResponse<MobileProductResponse>>(mobileService.getProducts(request), HttpStatus.OK);
	
	}
	
	
	
	   private int[] getLoginIdFromToken(HttpServletRequest request)
	    {
			String authHeader = request.getHeader("Authorization");
			int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
	        return requestValues;
	    }
	

}
