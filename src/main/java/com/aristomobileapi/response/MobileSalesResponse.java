package com.aristomobileapi.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MobileSalesResponse {
	
	private  String description;
	private double  budget;
	private double net;
	private double ach;
	private double surdef;
	private double net200;
	private double ach200;
	private double surdef200;
	private double credit;
	private double credit200;
	

}
