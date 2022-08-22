package com.hyperlink.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hyperlink.dto.ComplaintsDTO;
import com.hyperlink.dto.EmployeeCategoryDTO;
import com.hyperlink.dto.EmployeeDTO;
import com.hyperlink.entity.ComplaintsEntity;
import com.hyperlink.entity.EmployeeCategoryEntity;
import com.hyperlink.entity.EmployeeEntity;
import com.hyperlink.exception.ComplaintException;
import com.hyperlink.exception.EmployeeException;
import com.hyperlink.repository.ComplaintsRepository;
import com.hyperlink.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private ComplaintsRepository repo;
	
	public EmployeeEntity saveEmployee(EmployeeDTO dto,String photoName) {
		
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmail(dto.getEmail());
		entity.setMobile(dto.getMobile());
		entity.setName(dto.getName());
		entity.setPassword(dto.getPassword());
		entity.setPhoto(photoName);
		entity.setStatus(dto.getStatus());
		entity.setWorkingType(dto.getWorkingType());
		
		
		
		return repository.save(entity);
		
	}
	
	public String saveComplaints(ComplaintsDTO dto) {
		
		ComplaintsEntity entity = new ComplaintsEntity();
		entity.setCategoryId(dto.getCategoryId());
		entity.setDescription(dto.getDescription());
		entity.setEmp_id(dto.getEmp_id());
		entity.setRepliedDate(dto.getRepliedDate());
		entity.setReply(dto.getReply());
		entity.setStatus(dto.getStatus());
		repo.save(entity);
		return "Saved Complaint";
		
	}
	
	public List<ComplaintsDTO> getAllComplaints(){
		Pageable pageable=PageRequest.of(0, 5);
		Page<ComplaintsEntity> allRes= repo.findAll(pageable);
		List<ComplaintsEntity> listPage=allRes.getContent();
		List<ComplaintsDTO> list = new ArrayList<ComplaintsDTO>();
		for(ComplaintsEntity e : listPage) {
			ComplaintsDTO dto = new ComplaintsDTO();
			dto.setCategoryId(e.getCategoryId());
			dto.setDescription(e.getDescription());
			dto.setEmp_id(e.getEmp_id());
			dto.setId(e.getId());
			dto.setRepliedDate(e.getRepliedDate());
			dto.setReply(e.getReply());
			dto.setStatus(e.getStatus());
			list.add(dto);
		}
		return list;
	}
	
	public String deleteComplaintById(Integer id) throws ComplaintException {
		Optional<ComplaintsEntity> opt = repo.findById(id);
		ComplaintsEntity entity = opt.orElseThrow(()-> new ComplaintException("Not Found"));
		repo.deleteById(entity.getId());
		return "Deleted Complaint";
	}
	
	public String updateEmployee(EmployeeDTO dto) throws EmployeeException {
		Optional<EmployeeEntity> opt = repository.findById(dto.getId());
		
		EmployeeEntity entity = opt.orElseThrow(()-> new EmployeeException("Not Found"));
		Integer i = repository.update(dto.getName(), dto.getMobile(), dto.getPassword(), entity.getId());
		return "Updated Employee";
	}
	
}












