package com.aristomobileapi.serviceimpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aristomobileapi.constant.AristoWebMessageConstant;
import com.aristomobileapi.dao.DashBoardDao;
import com.aristomobileapi.dto.DashBoardBarChart;
import com.aristomobileapi.dto.DashBoardData;
import com.aristomobileapi.dto.DashBoardLineChart;
import com.aristomobileapi.response.ApiResponse;
import com.aristomobileapi.response.DashBoardChartResponse;
import com.aristomobileapi.response.DashBoardDataResponse;
import com.aristomobileapi.response.DataSetResponse;
import com.aristomobileapi.service.DashBoardService;

@Service
public class DashBoardServiceImpl implements DashBoardService {

	@Autowired
	private DashBoardDao dashBoardDao;
	
	@Autowired
	private AristoWebMessageConstant aristoWebMessageConstant;
	
	@Override
	public DashBoardChartResponse getDashboardMainChart(int myear, int mon, int login_id, int utype) {

		List<DashBoardBarChart> chartList= dashBoardDao.getDashboardMainChart(myear,mon,login_id,utype);
		
		DashBoardChartResponse dashBoardChartResponse=null;
		DashBoardBarChart dashBoardChart=null;
		List<Double> dataValueTarget=null;
		List<Double> dataValueSale=null;
		List<DataSetResponse> dataSetResponseList=null;
		Set<String> chartLabels = null;
		int size = chartList.size();
		int srno=0;
		boolean first=true;

	for(int i=0; i<size;i++)
		{
			dashBoardChart = chartList.get(i);
			if(first){
				dashBoardChartResponse = new DashBoardChartResponse();
				dataValueTarget = new ArrayList<Double>();
				dataValueSale = new ArrayList<Double>();
				dataSetResponseList = new ArrayList<>();
				chartLabels = new LinkedHashSet<>();
				first=false;
			}
          
			//chartLabels.add(dashBoardChart.getDivision());
			chartLabels.add(aristoWebMessageConstant.divisionMap.get(dashBoardChart.getDivision()));
			dataValueTarget.add(dashBoardChart.getBudget());
			dataValueSale.add(dashBoardChart.getNet());

                 }


		if(!first)
		{

			DataSetResponse dataSetResponse = new DataSetResponse();
			dataSetResponse.setValues(dataValueTarget);
			dataSetResponse.setDatasetLabel("Target");
			dataSetResponse.setDataSetColor(aristoWebMessageConstant.target);
			dataSetResponseList.add(dataSetResponse);


			dataSetResponse = new DataSetResponse();
			dataSetResponse.setValues(dataValueSale);
			dataSetResponse.setDatasetLabel("Sale");
			dataSetResponse.setDataSetColor(aristoWebMessageConstant.sale);
			dataSetResponseList.add(dataSetResponse);

			dashBoardChartResponse.setChartType("bar");
			dashBoardChartResponse.setChartTitle("Target Vs Sales");
			dashBoardChartResponse.setChartLabels(chartLabels);
			dashBoardChartResponse.setDataSet(dataSetResponseList);
		}

		return dashBoardChartResponse;
	}

	@Override
	public ApiResponse<DashBoardDataResponse> getDashboardYearCombo() {
		List<DashBoardData> dataList= dashBoardDao.getDashboardYearCombo();
		List<DashBoardDataResponse> yearList = getResponseData(dataList);
		

		
		int size=dataList.size();
		System.out.println("size is "+size);
		
		ApiResponse<DashBoardDataResponse> apiResponse = new ApiResponse<>(size,yearList);
		return apiResponse;
		
	}
	private List<DashBoardDataResponse> getResponseData(List<DashBoardData> dataList)
	{
		List<DashBoardDataResponse> saleList = new ArrayList<DashBoardDataResponse>();
		int size = dataList.size();
		
		DashBoardDataResponse response=null;
		
		
		for(int i=0; i<size;i++)
		{

			DashBoardData data = dataList.get(i);
			response= new DashBoardDataResponse();
			response.setName(data.getName());
			response.setValue(data.getVal());
			saleList.add(response);
		}
		return saleList;

	}

	@Override
	public DashBoardChartResponse getDashboardLineChart(int myear, int mon, int login_id, int utype) {
		List<DashBoardLineChart> chartList= dashBoardDao.getDashboardLineChart(myear,mon,login_id,utype);
		
		DashBoardChartResponse dashBoardChartResponse=null;
		DashBoardLineChart dashBoardChart=null;
		List<Double> dataValueTarget=null;
		List<Double> dataValueSale=null;
		List<DataSetResponse> dataSetResponseList=null;
		Set<String> chartLabels = null;
		List<Integer> chartInt=null;
		int size = chartList.size();
		boolean first=true;
	for(int i=0; i<size;i++)
		{
			dashBoardChart = chartList.get(i);
			if(first){
				dashBoardChartResponse = new DashBoardChartResponse();
				dataValueTarget = new ArrayList<Double>();
				dataValueSale = new ArrayList<Double>();
				dataSetResponseList = new ArrayList<>();
				chartLabels = new LinkedHashSet<>();
				chartInt = new ArrayList<Integer>();
				first=false;
			}
          
			chartLabels.add(dashBoardChart.getMnth());
			chartInt.add(i+1);
			dataValueTarget.add(dashBoardChart.getBudget());
			dataValueSale.add(dashBoardChart.getNet());

           }


		if(!first)
		{

			DataSetResponse dataSetResponse = new DataSetResponse();
			dataSetResponse.setValues(dataValueTarget);
			dataSetResponse.setDatasetLabel("Target");
			dataSetResponse.setDataSetColor(aristoWebMessageConstant.target);
			dataSetResponseList.add(dataSetResponse);


			dataSetResponse = new DataSetResponse();
			dataSetResponse.setValues(dataValueSale);
			dataSetResponse.setDatasetLabel("Sale");
			dataSetResponse.setDataSetColor(aristoWebMessageConstant.sale);
			dataSetResponseList.add(dataSetResponse);

			dashBoardChartResponse.setChartType("Line");
			dashBoardChartResponse.setChartTitle("Target Vs Sales");
			dashBoardChartResponse.setChartLabels(chartLabels);
			dashBoardChartResponse.setChartInt(chartInt);
			dashBoardChartResponse.setDataSet(dataSetResponseList);
		}

		return dashBoardChartResponse;
	}

	
}
