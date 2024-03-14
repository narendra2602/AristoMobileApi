package com.aristomobileapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristomobileapi.dto.Despatch;
import com.aristomobileapi.dto.MktDataDto;
import com.aristomobileapi.dto.SalesBranch;
import com.aristomobileapi.dto.SalesDivision;
import com.aristomobileapi.dto.SalesHq;
import com.aristomobileapi.dto.SalesStockiest;

public interface MobileSalesDao extends JpaRepository<MktDataDto, Integer> {
	
	@Query(value="CALL mobileReportGetSalesDiv(:myear,:smon,:login_id,:utype);", nativeQuery=true)
	List<SalesDivision> getSalesDivision(@Param("myear") int myear,	@Param("smon") int smon,@Param("login_id") int login_id,
			@Param("utype") int utype);

	@Query(value="CALL mobileReportGetSalesBranch(:myear,:smon,:login_id,:utype,:div_code);", nativeQuery=true)
	List<SalesBranch> getSalesBranch(@Param("myear") int myear,	@Param("smon") int smon,@Param("login_id") int login_id,
			@Param("utype") int utype,@Param("div_code") int div_code);

	@Query(value="CALL mobileReportGetSalesHq(:myear,:smon,:login_id,:utype,:div_code,:depo_code);", nativeQuery=true)
	List<SalesHq> getSalesHq(@Param("myear") int myear,	@Param("smon") int smon,@Param("login_id") int login_id,
			@Param("utype") int utype,@Param("div_code") int div_code,@Param("depo_code") int depo_code);

	@Query(value="CALL mobileReportGetSalesStockiest(:myear,:div_code,:depo_code,:smon,:hq_code);", nativeQuery=true)
	List<SalesStockiest> getSalesStockiest(@Param("myear") int myear,@Param("div_code") int div_code,@Param("depo_code") int depo_code
			,@Param("smon") int smon,@Param("hq_code") int hq_code);
	
	@Query(value="CALL mobileReportGetStockiestDetails(:myear,:div_code,:depo_code,:smon,:party_code);", nativeQuery=true)
	List<Despatch> getDespatchDetails(@Param("myear") int myear,@Param("div_code") int div_code,@Param("depo_code") int depo_code
			,@Param("smon") int smon,@Param("party_code") String  party_code);

	
}
