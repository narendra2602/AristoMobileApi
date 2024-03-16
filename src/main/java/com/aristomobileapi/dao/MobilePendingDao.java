package com.aristomobileapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristomobileapi.dto.MktDataDto;
import com.aristomobileapi.dto.PendingBranch;
import com.aristomobileapi.dto.PendingDivision;
import com.aristomobileapi.dto.PendingHq;
import com.aristomobileapi.dto.PendingStockiest;

public interface MobilePendingDao extends JpaRepository<MktDataDto, Integer>  {
	
	@Query(value="CALL mobileReportGetPendingPIDiv(:myear,:smon,:login_id,:utype);", nativeQuery=true)
	List<PendingDivision> getPendingDivision(@Param("myear") int myear,	@Param("smon") int smon,@Param("login_id") int login_id,
			@Param("utype") int utype);

	@Query(value="CALL mobileReportGetPendingPIBranch(:myear,:smon,:login_id,:utype,:div_code);", nativeQuery=true)
	List<PendingBranch> getPendingBranch(@Param("myear") int myear,	@Param("smon") int smon,@Param("login_id") int login_id,
			@Param("utype") int utype,@Param("div_code") int div_code);
	
	@Query(value="CALL mobileReportGetPendingPIHq(:myear,:smon,:login_id,:utype,:div_code,:depo_code);", nativeQuery=true)
	List<PendingHq> getPendingHq(@Param("myear") int myear,	@Param("smon") int smon,@Param("login_id") int login_id,
			@Param("utype") int utype,@Param("div_code") int div_code,@Param("depo_code") int depo_code);

	@Query(value="CALL mobileReportGetPendingPIStockiest(:myear,:div_code,:depo_code,:smon,:hq_code);", nativeQuery=true)
	List<PendingStockiest> getPendingStockiest(@Param("myear") int myear,@Param("div_code") int div_code,@Param("depo_code") int depo_code
			,@Param("smon") int smon,@Param("hq_code") int hq_code);

}
