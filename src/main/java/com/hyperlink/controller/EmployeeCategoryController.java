package com.hyperlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperlink.dto.EmployeeCategoryDTO;
import com.hyperlink.exception.EmployeeException;
import com.hyperlink.service.EmployeeCategoryService;

@RestController
@RequestMapping("/employee-category")
public class EmployeeCategoryController {
	
	@Autowired
	private EmployeeCategoryService service;
	
	@PostMapping("save/complaint")
	public ResponseEntity<String> saveComplaint(@RequestBody EmployeeCategoryDTO dto){
		
		String s = service.saveComplaint(dto);
		
		return new ResponseEntity<String>(s,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getAllActiveMappings")
	public ResponseEntity<List<EmployeeCategoryDTO>> getAllActiveCategories(){
		List<EmployeeCategoryDTO> res = service.getAllActiveCategories();
		return new ResponseEntity<List<EmployeeCategoryDTO>>(res,HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<EmployeeCategoryDTO> findById(@PathVariable Integer id) throws EmployeeException{
		
		EmployeeCategoryDTO dto = service.findById(id);
		return new ResponseEntity<EmployeeCategoryDTO>(dto,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) throws EmployeeException{
		String s = service.deleteById(id);
		return new ResponseEntity<String>(s,HttpStatus.OK);
	}
	
	

}









