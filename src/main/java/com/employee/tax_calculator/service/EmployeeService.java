package com.employee.tax_calculator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.tax_calculator.Vo.EmployeeInfoVo;

@Service
public interface EmployeeService {

	List<EmployeeInfoVo> findAll();

}
