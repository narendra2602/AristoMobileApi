package com.aristomobileapi.response;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MobilePendingStockiestResponse {
	
	private String code;
	private String name;
	private String city;
	private String piNo;
	private String   piDate;
	private String ordNo;
	private String   ordDate;
	private double amount;

}
