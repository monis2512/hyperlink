package com.hyperlink.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.hyperlink.dto.EmployeeDTO;
import com.hyperlink.entity.EmployeeEntity;

public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, Integer> {
	
	@Query("UPDATE EmployeeEntity employee SET employee.name=:name , employee.mobile=:mobile , employee.password=:password WHERE employee.id=:id")
	@Modifying
	@Transactional
	public Integer update(@Param("name") String name,@Param("mobile") Integer mobile,@Param("password") String password,@Param("id") Integer id);
	
	public EmployeeDTO findByEmail(String email);
	

}
