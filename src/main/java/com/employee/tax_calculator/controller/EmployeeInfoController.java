package com.employee.tax_calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.tax_calculator.Vo.EmployeeInfoVo;
import com.employee.tax_calculator.service.EmployeeService;



@RestController
@RequestMapping("/api")
public class EmployeeInfoController {
	
	@Autowired
	private EmployeeService employeeInfoService;

	@GetMapping("/getEmployeeList")
	public List<EmployeeInfoVo> getBooksList() {
		List<EmployeeInfoVo> List = employeeInfoService.findAll();
		return List;
		}
}
