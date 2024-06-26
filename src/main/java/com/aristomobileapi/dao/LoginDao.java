package com.aristomobileapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aristomobileapi.dto.LoginDto;
import com.aristomobileapi.dto.MktDataDto;
import com.aristomobileapi.dto.MobileVersion;
import com.aristomobileapi.dto.ReportMenuDto;

public interface LoginDao extends JpaRepository<MktDataDto, Integer> {
	
	@Query(value = "Select id,f_name,opt,last_ldate,last_ltime from login where login_name=:userName and password=:password and status=:active", nativeQuery = true)
	LoginDto authenticateUser(@Param("userName") String userName,@Param("password") String password,@Param("active") String active);


	@Query(value = "select r.tab_id,t.tab_name,r.repo_id,r.repo_name from aristo.repo_master08 r,tab_master08 t where r.tab_id=t.tabid and r.lock='Y' and r.repo_id in (select repo_id from user_rights08 where user_id=:userId and status='Y')  order by r.tab_id,r.repo_id ", nativeQuery = true)
	List<ReportMenuDto> getMenuList(@Param("userId") int userId);

/*	@Query(value = "Select distinct concat(b.ter_name,'-',u.u_date) msg from upload u,a_branch08 b where u.depo_code=:depoCode and u.depo_code = b.depo_code   ", nativeQuery = true)
	String getMessage(@Param("depoCode") int depoCode);
*/
	@Query(value = "Select concat('Last Update:',date_format(update_date,'%d/%m/%Y %h:%i:%s'))  msg from aristo_web.timetable where div_code=:divCode and depo_code =:depoCode   ", nativeQuery = true)
	String getMessage(@Param("divCode") int divCode,@Param("depoCode") int depoCode);

	@Query(value = "Select current_version,last_updated from aristo_web.mobile_version ", nativeQuery = true)
	MobileVersion getVersion();

}
