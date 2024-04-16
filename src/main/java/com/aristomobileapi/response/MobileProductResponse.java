package com.aristomobileapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MobileProductResponse {
	
	private  String name;
	private String pack;
	private int budgetVal;
	private int grossSaleVal;
	private int piSaleVal;
	private int totalSaleVal;
	private double achVal;
	private int surdefVal;
	private int cummBudgetVal;
	private int cummGrossSaleVal;
	private int cummPiSaleVal;
	private int cummTotalSaleVal;
	private double cummAchVal;
	private int cummSurdefVal;
	private int cummLysSaleVal;
	private double gthVal;
	private int budget;
	private int grossSale;
	private int piSale;
	private int totalSale;
	private double ach;
	private int surdef;
	private int cummBudget;
	private int cummGrossSale;
	private int cummPiSale;
	private int cummTotalSale;
	private double cummAch;
	private int cummSurdef;
	private int cummLysSale;
	private double gth;


}
