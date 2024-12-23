package com.employee.tax_calculator.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.tax_calculator.Vo.EmployeeInfoVo;
import com.employee.tax_calculator.Repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeInfoVo> findAll() {
		return employeeRepository.findAll();
	}

}
