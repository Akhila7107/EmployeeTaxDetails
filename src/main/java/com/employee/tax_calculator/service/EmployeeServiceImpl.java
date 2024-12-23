package com.employee.tax_calculator.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.tax_calculator.Vo.EmployeeInfoVo;


import com.employee.tax_calculator.Repository.EmployeeRepository;

@Service

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeInfoVo> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEntity(EmployeeInfoVo employeeInfo) {
		
		 employeeRepository.saveAndFlush(employeeInfo);
		
	}

	@Override
	public Optional<EmployeeInfoVo> getDataByEmployeeId(String employeeId) {
		return employeeRepository.findByEmployeeId(employeeId);
	}

}
