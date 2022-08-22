package com.hyperlink.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hyperlink.dto.EmployeeCategoryDTO;
import com.hyperlink.entity.EmployeeCategoryEntity;
import com.hyperlink.exception.EmployeeException;
import com.hyperlink.repository.EmployeeCategoryRepository;

@Service
public class EmployeeCategoryService {
	
	@Autowired
	private EmployeeCategoryRepository repo;
	
	public String saveComplaint(EmployeeCategoryDTO dto) {
		
		EmployeeCategoryEntity entity = new EmployeeCategoryEntity();
		
		entity.setCategoryType(dto.getCategoryType());
		entity.setStatus(dto.getStatus());
		repo.save(entity);
		return "Saved Complaint";
		
	}
	
	public List<EmployeeCategoryDTO> getAllActiveCategories(){
		Pageable pageable=PageRequest.of(0, 5);
		Page<EmployeeCategoryEntity> allRes= repo.findAll(pageable);
		List<EmployeeCategoryEntity> listPage=allRes.getContent();
		List<EmployeeCategoryDTO> list = new ArrayList<EmployeeCategoryDTO>();
		for(EmployeeCategoryEntity e : listPage) {
			if(e.getStatus().equalsIgnoreCase("active")) {
				EmployeeCategoryDTO dto = new EmployeeCategoryDTO();
				dto.setId(e.getId());
				dto.setCategoryType(e.getCategoryType());
				dto.setStatus(e.getStatus());
				list.add(dto);
			}
		}
		return list;
	}
	
	public EmployeeCategoryDTO findById(Integer id) throws EmployeeException{
		Optional<EmployeeCategoryEntity> opt = repo.findById(id);
		EmployeeCategoryEntity entity = opt.orElseThrow(()-> new EmployeeException("Not Found"));
		EmployeeCategoryDTO dto = new EmployeeCategoryDTO();
		dto.setCategoryType(entity.getCategoryType());
		dto.setId(entity.getId());
		dto.setStatus(entity.getStatus());
		return dto;
		
	}
	
	public String deleteById(Integer id) throws EmployeeException {
		Optional<EmployeeCategoryEntity> opt = repo.findById(id);
		EmployeeCategoryEntity entity = opt.orElseThrow(()-> new EmployeeException("Not Found"));
		
		repo.deleteById(entity.getId());
		
		return "Deleted Successfully";
	}

}
