package com.aristomobileapi.response;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DashBoardChartResponse {
	
	private String chartType;
	private List<Integer> chartInt;
	private String chartTitle;
	private Set<String> chartLabels;
	private List<DataSetResponse> dataSet;

}
