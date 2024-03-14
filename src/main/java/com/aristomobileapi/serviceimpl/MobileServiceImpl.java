package com.aristomobileapi.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristomobileapi.constant.AristoMobileLogMsgConstant;
import com.aristomobileapi.dao.MobileSalesDao;
import com.aristomobileapi.dto.Despatch;
import com.aristomobileapi.dto.SalesBranch;
import com.aristomobileapi.dto.SalesDivision;
import com.aristomobileapi.dto.SalesHq;
import com.aristomobileapi.dto.SalesStockiest;
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
import com.aristomobileapi.service.MobileService;
import com.aristomobileapi.utility.AppCalculationUtils;

@Service
public class MobileServiceImpl implements MobileService{

	Logger logger = LoggerFactory.getLogger(MobileServiceImpl.class);
	
	@Autowired
	private MobileSalesDao mobileSalesDao;
	
	@Override
	public ApiResponse<MobileSalesResponse> getDivision(DivisionRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_DIVISION,"getDivision");
		List<SalesDivision> DivisionList=null;
		int size = 0;
		
		DivisionList=mobileSalesDao.getSalesDivision(request.getMyear(),request.getMonth(),request.getLoginId(),request.getUtype());

		size = DivisionList.size();
		logger.info("size of the data is {}",size);

		MobileSalesResponse response=null;
		List<MobileSalesResponse> saleList = new ArrayList();
		String title=null;
		for (int i=0;i<size;i++)
		{
			SalesDivision data = DivisionList.get(i);
			response=new MobileSalesResponse();
			response.setDescription(data.getDescription());
	    	response.setBudget(AppCalculationUtils.valueDivideByLacInDouble(data.getBudget()));
	    	response.setNet(AppCalculationUtils.valueDivideByLacInDouble(data.getNet()));
			response.setAch(data.getAch());
	    	response.setSurdef(AppCalculationUtils.valueDivideByLacInDouble(data.getSur()));
	    	response.setNet200(AppCalculationUtils.valueDivideByLacInDouble(data.getNet200()));
			response.setAch200(data.getAch2());
	    	response.setSurdef200(AppCalculationUtils.valueDivideByLacInDouble(data.getSur2()));
	    	response.setCredit(AppCalculationUtils.valueDivideByLacInDouble(data.getCrd()));
	    	response.setCredit200(AppCalculationUtils.valueDivideByLacInDouble(data.getCrd200()));
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileSalesResponse> apiResponse = new ApiResponse<>(title!=null?title.toString():"", size,saleList);
		return apiResponse;

	}

	@Override
	public ApiResponse<MobileSalesResponse> getBranch(BranchRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_BRANCH,"getBranch");
		List<SalesBranch> BranchList=null;
		int size = 0;
		
		BranchList=mobileSalesDao.getSalesBranch(request.getMyear(),request.getMonth(),request.getLoginId(),request.getUtype(),request.getDivCode());

		size = BranchList.size();
		logger.info("size of the data is {}",size);

		MobileSalesResponse response=null;
		List<MobileSalesResponse> saleList = new ArrayList();
		String title=null;
		for (int i=0;i<size;i++)
		{
			SalesBranch data = BranchList.get(i);
			response=new MobileSalesResponse();
			response.setDescription(data.getDescription());
	    	response.setBudget(AppCalculationUtils.valueDivideByLacInDouble(data.getBudget()));
	    	response.setNet(AppCalculationUtils.valueDivideByLacInDouble(data.getNet()));
			response.setAch(data.getAch());
	    	response.setSurdef(AppCalculationUtils.valueDivideByLacInDouble(data.getSur()));
	    	response.setNet200(AppCalculationUtils.valueDivideByLacInDouble(data.getNet200()));
			response.setAch200(data.getAch2());
	    	response.setSurdef200(AppCalculationUtils.valueDivideByLacInDouble(data.getSur2()));
	    	response.setCredit(AppCalculationUtils.valueDivideByLacInDouble(data.getCrd()));
	    	response.setCredit200(AppCalculationUtils.valueDivideByLacInDouble(data.getCrd200()));
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileSalesResponse> apiResponse = new ApiResponse<>(title!=null?title.toString():"", size,saleList);
		return apiResponse;
	}

	@Override
	public ApiResponse<MobileSalesResponse> getHq(HqRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_HQ,"getHq");
		List<SalesHq> HqList=null;
		int size = 0;
		
		HqList=mobileSalesDao.getSalesHq(request.getMyear(),request.getMonth(),request.getLoginId(),request.getUtype(),request.getDivCode(),request.getDepoCode());
		
		size = HqList.size();
		logger.info("size of the data is {}",size);

		MobileSalesResponse response=null;
		List<MobileSalesResponse> saleList = new ArrayList();
		String title=null;
		for (int i=0;i<size;i++)
		{
			SalesHq data = HqList.get(i);
			response=new MobileSalesResponse();
			response.setDescription(data.getDescription());
	    	response.setBudget(data.getBudget());
	    	response.setNet(data.getNet());
			response.setAch(data.getAch());
	    	response.setSurdef(data.getSur());
	    	response.setNet200(data.getNet200());
			response.setAch200(data.getAch2());
	    	response.setSurdef200(data.getSur2());
	    	response.setCredit(data.getCrd());
	    	response.setCredit200(data.getCrd200());
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileSalesResponse> apiResponse = new ApiResponse<>(title!=null?title.toString():"", size,saleList);
		return apiResponse;
	}

	@Override
	public ApiResponse<MobileStockiestResponse> getStockiest(StockiestRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_STK,"getStockiest");
		List<SalesStockiest> StkList=null;
		int size = 0;
		
		StkList=mobileSalesDao.getSalesStockiest(request.getMyear(),request.getDivCode(),request.getDepoCode(),request.getMonth(),request.getHqCode());
		
		size = StkList.size();
		logger.info("size of the data is {}",size);

		MobileStockiestResponse response=null;
		List<MobileStockiestResponse> saleList = new ArrayList();
		String title=null;
		for (int i=0;i<size;i++)
		{
			SalesStockiest data = StkList.get(i);
			response=new MobileStockiestResponse();
			response.setName(data.getName());
			response.setCity(data.getCity());
	    	response.setSales(data.getSales());
	    	response.setCredit(data.getCredit());
	    	response.setNet(data.getNet());
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileStockiestResponse> apiResponse = new ApiResponse<>(title!=null?title.toString():"", size,saleList);
		return apiResponse;
	}

	@Override
	public ApiResponse<MobileDespatchResponse> getDespatchDivision(DivisionRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_DIVISION,"getDivision");
		List<SalesDivision> DivisionList=null;
		int size = 0;
		
		DivisionList=mobileSalesDao.getSalesDivision(request.getMyear(),request.getMonth(),request.getLoginId(),request.getUtype());

		size = DivisionList.size();
		logger.info("size of the data is {}",size);

		MobileDespatchResponse response=null;
		List<MobileDespatchResponse> saleList = new ArrayList();
		String title=null;
		for (int i=0;i<size;i++)
		{
			SalesDivision data = DivisionList.get(i);
			response=new MobileDespatchResponse();
			response.setDescription(data.getDescription());
	    	response.setBillAmount(AppCalculationUtils.valueDivideByLacInDouble(data.getBill_amt()));
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileDespatchResponse> apiResponse = new ApiResponse<>(title!=null?title.toString():"", size,saleList);
		return apiResponse;


	}

	@Override
	public ApiResponse<MobileDespatchResponse> getDespatchBranch(BranchRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_BRANCH,"getBranch");
		List<SalesBranch> BranchList=null;
		int size = 0;
		
		BranchList=mobileSalesDao.getSalesBranch(request.getMyear(),request.getMonth(),request.getLoginId(),request.getUtype(),request.getDivCode());

		size = BranchList.size();
		logger.info("size of the data is {}",size);

		MobileDespatchResponse response=null;
		List<MobileDespatchResponse> saleList = new ArrayList();
		String title=null;
		for (int i=0;i<size;i++)
		{
			SalesBranch data = BranchList.get(i);
			response=new MobileDespatchResponse();
			response.setDescription(data.getDescription());
	    	response.setBillAmount(AppCalculationUtils.valueDivideByLacInDouble(data.getBill_amt()));
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileDespatchResponse> apiResponse = new ApiResponse<>(title!=null?title.toString():"", size,saleList);
		return apiResponse;
	}

	@Override
	public ApiResponse<MobileDespatchResponse> getDespatchHq(HqRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_HQ,"getHq");
		List<SalesHq> HqList=null;
		int size = 0;
		
		HqList=mobileSalesDao.getSalesHq(request.getMyear(),request.getMonth(),request.getLoginId(),request.getUtype(),request.getDivCode(),request.getDepoCode());
		
		size = HqList.size();
		logger.info("size of the data is {}",size);

		MobileDespatchResponse response=null;
		List<MobileDespatchResponse> saleList = new ArrayList();
		String title=null;
		for (int i=0;i<size;i++)
		{
			SalesHq data = HqList.get(i);
			response=new MobileDespatchResponse();
			response.setDescription(data.getDescription());
	    	response.setBillAmount(data.getBill_amt());
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileDespatchResponse> apiResponse = new ApiResponse<>(title!=null?title.toString():"", size,saleList);
		return apiResponse;
	}

	@Override
	public ApiResponse<MobileDespatchStockiestResponse> getDespatchStockiest(StockiestRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_STK,"getStockiest");
		List<SalesStockiest> StkList=null;
		int size = 0;
		
		StkList=mobileSalesDao.getSalesStockiest(request.getMyear(),request.getDivCode(),request.getDepoCode(),request.getMonth(),request.getHqCode());
		
		size = StkList.size();
		logger.info("size of the data is {}",size);

		MobileDespatchStockiestResponse response=null;
		List<MobileDespatchStockiestResponse> saleList = new ArrayList();
		String title=null;
		for (int i=0;i<size;i++)
		{
			SalesStockiest data = StkList.get(i);
			response=new MobileDespatchStockiestResponse();
			response.setName(data.getName());
			response.setCity(data.getCity());
	    	response.setBillAmount(data.getBill_amt());
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileDespatchStockiestResponse> apiResponse = new ApiResponse<>(title!=null?title.toString():"", size,saleList);
		return apiResponse;
	}

	@Override
	public ApiResponse<DespatchResponse> getDespatchDetail(StockiestDetailRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_STK,"getStockiest");
		List<Despatch> StkList=null;
		int size = 0;
		StkList=mobileSalesDao.getDespatchDetails(request.getMyear(),request.getDivCode(),request.getDepoCode(),request.getMonth(),request.getPartyCode());
		
		size = StkList.size();
		logger.info("size of the data is {}",size);

		DespatchResponse response=null;
		List<DespatchResponse> saleList = new ArrayList();
		String title=null;
		for (int i=0;i<size;i++)
		{
			Despatch data = StkList.get(i);
			if(data.getTyp()==1)
			{
			response=new DespatchResponse();
			response.setInvNo(data.getIno()); 
			response.setInvDate(data.getInv_date());
	    	response.setBillAmount(data.getBill_amt());
	    	response.setOrderNo(data.getOrder_no());
			}
			else
			{
			response=new DespatchResponse();
			response.setInvNo("Total");
			response.setInvDate("");
	    	response.setBillAmount(data.getBill_amt());
	    	response.setOrderNo("");
			}
				
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<DespatchResponse> apiResponse = new ApiResponse<>(title!=null?title.toString():"", size,saleList);
		return apiResponse;

		
	}

}
