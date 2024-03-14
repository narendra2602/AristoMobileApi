package com.aristomobileapi.service;

import com.aristomobileapi.request.BranchRequest;
import com.aristomobileapi.request.DivisionRequest;
import com.aristomobileapi.request.HqRequest;
import com.aristomobileapi.request.StockiestDetailRequest;
import com.aristomobileapi.request.StockiestRequest;
import com.aristomobileapi.response.ApiResponse;
import com.aristomobileapi.response.DespatchResponse;
import com.aristomobileapi.response.MobileDespatchResponse;
import com.aristomobileapi.response.MobileDespatchStockiestResponse;
import com.aristomobileapi.response.MobileSalesResponse;
import com.aristomobileapi.response.MobileStockiestResponse;

public interface MobileService  {

	ApiResponse<MobileSalesResponse> getDivision(DivisionRequest request);
	ApiResponse<MobileSalesResponse> getBranch(BranchRequest request);
	ApiResponse<MobileSalesResponse> getHq(HqRequest request);
	ApiResponse<MobileStockiestResponse> getStockiest(StockiestRequest request);

	ApiResponse<MobileDespatchResponse> getDespatchDivision(DivisionRequest request);
	ApiResponse<MobileDespatchResponse> getDespatchBranch(BranchRequest request);
	ApiResponse<MobileDespatchResponse> getDespatchHq(HqRequest request);
	ApiResponse<MobileDespatchStockiestResponse> getDespatchStockiest(StockiestRequest request);
	ApiResponse<DespatchResponse> getDespatchDetail(StockiestDetailRequest request);

}
