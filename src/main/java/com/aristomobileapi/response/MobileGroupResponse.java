package com.aristomobileapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MobileGroupResponse {
	
	private int grpCode;
	private  String name;
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
