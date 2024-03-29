package com.aristomobileapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristomobileapi.dto.DashBoardBarChart;
import com.aristomobileapi.dto.DashBoardData;
import com.aristomobileapi.dto.DashBoardLineChart;
import com.aristomobileapi.dto.MktDataDto;

public interface DashBoardDao extends JpaRepository<MktDataDto, Integer> {
	
	
	@Query(value="CALL mobileDashBoardChart(:myear,:mon,:login_id,:utype);", nativeQuery=true)
	List<DashBoardBarChart> getDashboardMainChart(@Param("myear") int myear,@Param("mon") int mon,
	@Param("login_id") int login_id,@Param("utype") int utype);

	@Query(value="CALL getDashboardYearCombo();", nativeQuery=true)
	List<DashBoardData>  getDashboardYearCombo();


	@Query(value="CALL mobileDashBoardLineChart(:myear,:mon,:login_id,:utype);", nativeQuery=true)
	List<DashBoardLineChart> getDashboardLineChart(@Param("myear") int myear,@Param("mon") int mon,
	@Param("login_id") int login_id,@Param("utype") int utype);

}
