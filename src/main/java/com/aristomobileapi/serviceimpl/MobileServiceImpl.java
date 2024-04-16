package com.aristomobileapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristomobileapi.constant.AristoMobileLogMsgConstant;
import com.aristomobileapi.dao.MobilePendingDao;
import com.aristomobileapi.dao.MobileSalesDao;
import com.aristomobileapi.dto.Despatch;
import com.aristomobileapi.dto.PendingBranch;
import com.aristomobileapi.dto.PendingDivision;
import com.aristomobileapi.dto.PendingHq;
import com.aristomobileapi.dto.PendingStockiest;
import com.aristomobileapi.dto.SalesBranch;
import com.aristomobileapi.dto.SalesDivision;
import com.aristomobileapi.dto.SalesGroup;
import com.aristomobileapi.dto.SalesHq;
import com.aristomobileapi.dto.SalesProduct;
import com.aristomobileapi.dto.SalesStockiest;
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
import com.aristomobileapi.utility.AppCalculationUtils;

@Service
public class MobileServiceImpl implements MobileService{

	Logger logger = LoggerFactory.getLogger(MobileServiceImpl.class);
	
	@Autowired
	private MobileSalesDao mobileSalesDao;

	@Autowired
	private MobilePendingDao mobilePendingDao;

	
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
		if(size==1)
			size=0;
		for (int i=0;i<size;i++)
		{
			SalesDivision data = DivisionList.get(i);
			response=new MobileSalesResponse();
			response.setCode(data.getDiv_Code());
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
	    	if(data.getDiv_Code()==0)
	    		response.setEntityType(3);
	    	else
	    		response.setEntityType(0);

	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileSalesResponse> apiResponse = new ApiResponse<>(size,saleList);
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
		if(size==1)
			size=0;

		for (int i=0;i<size;i++)
		{
			SalesBranch data = BranchList.get(i);
			response=new MobileSalesResponse();
			response.setCode(data.getDepo_Code());
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
	    	if(data.getDepo_Code()==0)
	    		response.setEntityType(3);
	    	else
	    		response.setEntityType(0);
	    		
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileSalesResponse> apiResponse = new ApiResponse<>(size,saleList);
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
		if(size==1)
			size=0;

		for (int i=0;i<size;i++)
		{
			SalesHq data = HqList.get(i);
			response=new MobileSalesResponse();
			response.setCode(data.getCode());
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
	    	response.setEntityType(data.getEntity_type());
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileSalesResponse> apiResponse = new ApiResponse<>(size,saleList);
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
		if(size==1)
			size=0;

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

		
		ApiResponse<MobileStockiestResponse> apiResponse = new ApiResponse<>(size,saleList);
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
		if(size==1)
			size=0;

		for (int i=0;i<size;i++)
		{
			SalesDivision data = DivisionList.get(i);
			response=new MobileDespatchResponse();
			response.setCode(data.getDiv_Code());
			response.setDescription(data.getDescription());
	    	response.setBillAmount(AppCalculationUtils.valueDivideByLacInDouble(data.getBill_amt()));
	    	if(data.getDiv_Code()==0)
	    		response.setEntityType(3);
	    	else
	    		response.setEntityType(0);

	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileDespatchResponse> apiResponse = new ApiResponse<>(size,saleList);
		return apiResponse;


	}

	@Override
	public ApiResponse<MobileDespatchResponse> getDespatchBranch(BranchRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_BRANCH,"getDespatchBranch");
		List<SalesBranch> BranchList=null;
		int size = 0;
		
		BranchList=mobileSalesDao.getSalesBranch(request.getMyear(),request.getMonth(),request.getLoginId(),request.getUtype(),request.getDivCode());

		size = BranchList.size();
		logger.info("size of the data is {}",size);

		MobileDespatchResponse response=null;
		List<MobileDespatchResponse> saleList = new ArrayList();
		String title=null;
		if(size==1)
			size=0;

		for (int i=0;i<size;i++)
		{
			SalesBranch data = BranchList.get(i);
			response=new MobileDespatchResponse();
			response.setCode(data.getDepo_Code());
			response.setDescription(data.getDescription());
	    	response.setBillAmount(AppCalculationUtils.valueDivideByLacInDouble(data.getBill_amt()));
	    	if(data.getDepo_Code()==0)
	    		response.setEntityType(3);
	    	else
	    		response.setEntityType(0);

	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileDespatchResponse> apiResponse = new ApiResponse<>(size,saleList);
		return apiResponse;
	}

	@Override
	public ApiResponse<MobileDespatchResponse> getDespatchHq(HqRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_HQ,"getDespatchHq");
		List<SalesHq> HqList=null;
		int size = 0;
		
		HqList=mobileSalesDao.getSalesHq(request.getMyear(),request.getMonth(),request.getLoginId(),request.getUtype(),request.getDivCode(),request.getDepoCode());
		
		size = HqList.size();
		logger.info("size of the data is {}",size);

		MobileDespatchResponse response=null;
		List<MobileDespatchResponse> saleList = new ArrayList();
		String title=null;
		if(size==1)
			size=0;

		for (int i=0;i<size;i++)
		{
			SalesHq data = HqList.get(i);
			response=new MobileDespatchResponse();
			response.setCode(data.getCode());
			response.setDescription(data.getDescription());
	    	response.setBillAmount(data.getBill_amt());
	    	response.setEntityType(data.getEntity_type());
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileDespatchResponse> apiResponse = new ApiResponse<>(size,saleList);
		return apiResponse;
	}

	@Override
	public ApiResponse<MobileDespatchStockiestResponse> getDespatchStockiest(StockiestRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_STK,"getDespatchStockiest");
		List<SalesStockiest> StkList=null;
		int size = 0;
		
		StkList=mobileSalesDao.getSalesStockiest(request.getMyear(),request.getDivCode(),request.getDepoCode(),request.getMonth(),request.getHqCode());
		
		size = StkList.size();
		logger.info("size of the data is {}",size);

		MobileDespatchStockiestResponse response=null;
		List<MobileDespatchStockiestResponse> saleList = new ArrayList();
		String title=null;
		if(size==1)
			size=0;

		for (int i=0;i<size;i++)
		{
			SalesStockiest data = StkList.get(i);
			response=new MobileDespatchStockiestResponse();
			response.setCode(data.getCode());
			response.setName(data.getName());
			response.setCity(data.getCity());
	    	response.setBillAmount(data.getBill_amt());
	    	
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileDespatchStockiestResponse> apiResponse = new ApiResponse<>(size,saleList);
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
		if(size==1)
			size=0;

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

		
		ApiResponse<DespatchResponse> apiResponse = new ApiResponse<>(size,saleList);
		return apiResponse;

		
	}

	@Override
	public ApiResponse<MobilePendingResponse> getPendingDivision(DivisionRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_DIVISION,"getPendingDivision");
		List<PendingDivision> DivisionList=null;
		int size = 0;
		
		DivisionList=mobilePendingDao.getPendingDivision(request.getMyear(),request.getMonth(),request.getLoginId(),request.getUtype());

		size = DivisionList.size();
		logger.info("size of the data is {}",size);

		MobilePendingResponse response=null;
		List<MobilePendingResponse> saleList = new ArrayList();
		String title=null;
    	if(size==1)
    		size=0;

		for (int i=0;i<size;i++)
		{
			PendingDivision data = DivisionList.get(i);
			response=new MobilePendingResponse();
			response.setCode(data.getDiv_code());
			response.setDescription(data.getDescription());
	    	response.setAmount(AppCalculationUtils.valueDivideByLacInDouble(data.getSales()));
	    	if(data.getDiv_code()==0)
	    		response.setEntityType(3);
	    	else
	    		response.setEntityType(0);

	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobilePendingResponse> apiResponse = new ApiResponse<>(size,saleList);
			return apiResponse;
	}

	@Override
	public ApiResponse<MobilePendingResponse> getPendingBranch(BranchRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_BRANCH,"getPendingBranch");
		List<PendingBranch> BranchList=null;
		int size = 0;
		
		BranchList=mobilePendingDao.getPendingBranch(request.getMyear(),request.getMonth(),request.getLoginId(),request.getUtype(),request.getDivCode());

		size = BranchList.size();
		logger.info("size of the data is {}",size);

		MobilePendingResponse response=null;
		List<MobilePendingResponse> saleList = new ArrayList();
		String title=null;
    	if(size==1)
    		size=0;
		for (int i=0;i<size;i++)
		{
			PendingBranch data = BranchList.get(i);
			response=new MobilePendingResponse();
			response.setCode(data.getDepo_Code());
			response.setDescription(data.getDescription());
	    	response.setAmount(AppCalculationUtils.valueDivideByLacInDouble(data.getSales()));
	    	if(data.getDepo_Code()==0)
	    		response.setEntityType(3);
	    	else
	    		response.setEntityType(0);

	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobilePendingResponse> apiResponse = new ApiResponse<>(size,saleList);
		return apiResponse;
	}

	@Override
	public ApiResponse<MobilePendingResponse> getPendingHq(HqRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_HQ,"getPendingHq");
		List<PendingHq> HqList=null;
		int size = 0;
		
		HqList=mobilePendingDao.getPendingHq(request.getMyear(),request.getMonth(),request.getLoginId(),request.getUtype(),request.getDivCode(),request.getDepoCode());
		
		size = HqList.size();
		logger.info("size of the data is {}",size);

		MobilePendingResponse response=null;
		List<MobilePendingResponse> saleList = new ArrayList();
		String title=null;
    	if(size==1)
    		size=0;
		for (int i=0;i<size;i++)
		{
			PendingHq data = HqList.get(i);
			response=new MobilePendingResponse();
			response.setCode(data.getCode());
			response.setDescription(data.getDescription());
	    	response.setAmount(data.getSales());
//	    	response.setEntityType(data.getEntity_type());
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobilePendingResponse> apiResponse = new ApiResponse<>(size,saleList);
		return apiResponse;
	}

	@Override
	public ApiResponse<MobilePendingStockiestResponse> getPendingStockiest(StockiestRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_STK,"getPendingStockiest");
		List<PendingStockiest> StkList=null;
		int size = 0;
		
		StkList=mobilePendingDao.getPendingStockiest(request.getMyear(),request.getDivCode(),request.getDepoCode(),request.getMonth(),request.getHqCode());
		
		size = StkList.size();
		logger.info("size of the data is {}",size);

		MobilePendingStockiestResponse response=null;
		List<MobilePendingStockiestResponse> saleList = new ArrayList();
		String title=null;
		if(size==1)
			size=0;

		for (int i=0;i<size;i++)
		{
			PendingStockiest data = StkList.get(i);
			response=new MobilePendingStockiestResponse();
			response.setCode(data.getCode());
			response.setName(data.getName());
			response.setCity(data.getCity());
			response.setPiNo(data.getPino());
			response.setPiDate(data.getPidate());
			response.setOrdNo(data.getOrdno());
			response.setOrdDate(data.getOrddate());
	    	response.setAmount(data.getSales());
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobilePendingStockiestResponse> apiResponse = new ApiResponse<>(size,saleList);
		return apiResponse;
	}

	@Override
	public ApiResponse<MobileGroupResponse> getGroups(GroupRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_GROUP,"getGroups");
		List<SalesGroup> GrpList=null;
		int size = 0;
		
		GrpList=mobileSalesDao.getSalesGroup(request.getMyear(),request.getDivCode(),request.getDepoCode(),request.getMonth(),request.getHqCode());
		
		size = GrpList.size();
		logger.info("size of the data is {}",size);

		MobileGroupResponse response=null;
		List<MobileGroupResponse> saleList = new ArrayList();
		String title=null;
		if(size==1)
			size=0;

		for (int i=0;i<size;i++)
		{
			SalesGroup data = GrpList.get(i);
			response=new MobileGroupResponse();
			response.setGrpCode(data.getGrp_code());
			response.setName(data.getName());
	    	response.setBudget(data.getMth_target_val());
	    	response.setGrossSale(data.getMth_gross_val());
	    	response.setPiSale(data.getMth_pi_val());
	    	response.setTotalSale(data.getMth_total_val());
	    	response.setAch(data.getMth_ach());
	    	response.setSurdef(data.getMth_surdef_val());
	    	response.setCummBudget(data.getCum_target_val());
	    	response.setCummGrossSale(data.getCum_gross_val());
	    	response.setCummPiSale(data.getCum_pi_val());
	    	response.setCummTotalSale(data.getCum_total_val());
	    	response.setCummAch(data.getCum_ach());
	    	response.setCummSurdef(data.getCum_surdef_val());
	    	response.setCummLysSale(data.getCum_lys_val());
	    	response.setGth(data.getGth());
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileGroupResponse> apiResponse = new ApiResponse<>(size,saleList);
		return apiResponse;
	}

	@Override
	public ApiResponse<MobileProductResponse> getProducts(ProductRequest request) {
		logger.info(AristoMobileLogMsgConstant.MOBILE_REPORT_GROUP,"getGroups");
		List<SalesProduct> PrdList=null;
		int size = 0;
		
		PrdList=mobileSalesDao.getSalesProduct(request.getMyear(),request.getDivCode(),request.getDepoCode(),request.getMonth(),request.getHqCode(),request.getGpCode());
		
		size = PrdList.size();
		logger.info("size of the data is {}",size);

		MobileProductResponse response=null;
		List<MobileProductResponse> saleList = new ArrayList();
		String title=null;
		if(size==1)
			size=0;

		for (int i=0;i<size;i++)
		{
			SalesProduct data = PrdList.get(i);
			response=new MobileProductResponse();
			response.setName(data.getName());
			response.setPack(data.getPack());
	    	response.setBudgetVal(data.getMth_target_val());
	    	response.setGrossSaleVal(data.getMth_gross_val());
	    	response.setPiSaleVal(data.getMth_pi_val());
	    	response.setTotalSaleVal(data.getMth_total_val());
	    	response.setAchVal(data.getMth_ach_val());
	    	response.setSurdefVal(data.getMth_surdef_val());
	    	response.setCummBudgetVal(data.getCum_target_val());
	    	response.setCummGrossSaleVal(data.getCum_gross_val());
	    	response.setCummPiSaleVal(data.getCum_pi_val());
	    	response.setCummTotalSaleVal(data.getCum_total_val());
	    	response.setCummAchVal(data.getCum_ach_val());
	    	response.setCummSurdefVal(data.getCum_surdef_val());
	    	response.setCummLysSaleVal(data.getCum_lys_val());
	    	response.setGthVal(data.getGth_val());

	    	response.setBudget(data.getMth_target());
	    	response.setGrossSale(data.getMth_gross());
	    	response.setPiSale(data.getMth_pi());
	    	response.setTotalSale(data.getMth_total());
	    	response.setAch(data.getMth_ach());
	    	response.setSurdef(data.getMth_surdef());
	    	response.setCummBudget(data.getCum_target());
	    	response.setCummGrossSale(data.getCum_gross());
	    	response.setCummPiSale(data.getCum_pi());
	    	response.setCummTotalSale(data.getCum_total());
	    	response.setCummAch(data.getCum_ach());
	    	response.setCummSurdef(data.getCum_surdef());
	    	response.setCummLysSale(data.getCum_lys());
	    	response.setGth(data.getGth());

	    	
	    	saleList.add(response);

		} //end of for loop

		
		ApiResponse<MobileProductResponse> apiResponse = new ApiResponse<>(size,saleList);
		return apiResponse;
	}

}
