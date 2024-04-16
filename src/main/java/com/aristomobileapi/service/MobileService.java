package com.aristomobileapi.service;

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
	
	ApiResponse<MobilePendingResponse> getPendingDivision(DivisionRequest request);
	ApiResponse<MobilePendingResponse> getPendingBranch(BranchRequest request);
	ApiResponse<MobilePendingResponse> getPendingHq(HqRequest request);
	ApiResponse<MobilePendingStockiestResponse> getPendingStockiest(StockiestRequest request);
	
	ApiResponse<MobileGroupResponse> getGroups(GroupRequest request);
	ApiResponse<MobileProductResponse> getProducts(ProductRequest request);
	
}
