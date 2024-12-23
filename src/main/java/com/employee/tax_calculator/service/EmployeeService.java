package com.employee.tax_calculator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employee.tax_calculator.Vo.EmployeeInfoVo;

@Service
public interface EmployeeService {

	List<EmployeeInfoVo> findAll();

	void saveEntity(EmployeeInfoVo employeeInfo);

	Optional<EmployeeInfoVo> getDataByEmployeeId(String employeeId);

}
