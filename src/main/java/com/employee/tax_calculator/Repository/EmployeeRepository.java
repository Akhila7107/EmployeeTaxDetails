package com.employee.tax_calculator.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.tax_calculator.Vo.EmployeeInfoVo;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInfoVo, String>{

	Optional<EmployeeInfoVo> findByEmployeeId(String employeeId);

}
