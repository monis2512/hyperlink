package com.hyperlink.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hyperlink.dto.ComplaintsDTO;
import com.hyperlink.dto.EmployeeDTO;
import com.hyperlink.entity.EmployeeEntity;
import com.hyperlink.service.EmployeeService;
import com.hyperlink.utility.FileUploadUtil;

@RestController
@CrossOrigin
@RequestMapping("/employee-controller")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("employee/save")
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDTO dto, @RequestParam("image") MultipartFile file) throws IOException{
		
		String photoName = StringUtils.cleanPath(file.getOriginalFilename());
		EmployeeEntity entity= service.saveEmployee(dto, photoName);
		String uploadDir = "user-photos/" + entity.getId();
		FileUploadUtil.saveFile(uploadDir, photoName, file);
		return new ResponseEntity<String>("",HttpStatus.OK);
		
	}
	
	@PostMapping("employee/saveComplaint") 
	public ResponseEntity<String> saveComplaint(@RequestBody ComplaintsDTO dto){
		String s = service.saveComplaints(dto);
		return new ResponseEntity<String>(s,HttpStatus.OK);
	}

	@GetMapping("employee/getAllComplaints")
	public ResponseEntity<List<ComplaintsDTO>> getAllComplaints(){
		
		List<ComplaintsDTO> list = service.getAllComplaints();
		return new ResponseEntity<List<ComplaintsDTO>>(list,HttpStatus.OK);
		
	}
	
}















