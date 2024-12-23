package com.employee.tax_calculator.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.tax_calculator.Vo.EmployeeInfoVo;
import com.employee.tax_calculator.service.EmployeeService;




@RestController
@RequestMapping("/api")
public class EmployeeInfoController {
	
	@Autowired
	private EmployeeService employeeInfoService;

	@GetMapping("/getEmployeeList")
	public List<EmployeeInfoVo> getEmployeeList() {
		List<EmployeeInfoVo> List = employeeInfoService.findAll();
		return List;
		}
	
	@PostMapping("/employees")
    public void SaveBookdetails(@RequestBody EmployeeInfoVo employeeInfo) {
		employeeInfoService.saveEntity(employeeInfo);
    }
	
	@GetMapping("/getDataByEmployeeId")
	public Optional<EmployeeInfoVo> getDataByEmployeeId(@RequestParam String EmployeeId) {
		Optional<EmployeeInfoVo> List = employeeInfoService.getDataByEmployeeId(EmployeeId);
		return List;
		}
	
	@GetMapping("/getTaxAmountDataByEmployeeId")
	public double getTaxAmountDataByEmployeeId(@RequestParam String EmployeeId,String FLAG) {
		Optional<EmployeeInfoVo> List = employeeInfoService.getDataByEmployeeId(EmployeeId);
		if(!List.isPresent()) {
			return 0;
		}
		double MonthlySalary = List.get().getSalary();
		String dojString = List.get().getDoj().toString(); // Assuming getDoj() returns a String in "YYYY-MM-DD" format

        // Convert String to LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate doj = LocalDate.parse(dojString, formatter);

	        // Calculate prorated salary based on DOJ
	        LocalDate currentYearStart = LocalDate.of(LocalDate.now().getYear(), Month.APRIL, 1);
	        LocalDate currentYearEnd = LocalDate.of(LocalDate.now().getYear(), Month.MARCH, 31);
	        long monthsEmployed = ChronoUnit.MONTHS.between(doj, currentYearEnd) + 1; // Include the month of joining
	        double proratedSalary = (MonthlySalary) * monthsEmployed;

	        // Calculate tax based on prorated salary
	        double taxableSalary = proratedSalary;
	        double totalTax = 0;
	        double cess = 0;

	        if (taxableSalary <= 250000) {
	            // No tax
	        } else if (taxableSalary <= 500000) {
	            totalTax = (taxableSalary - 250000) * 0.05;
	        } else if (taxableSalary <= 1000000) {
	            totalTax = (250000 * 0.05) + ((taxableSalary - 500000) * 0.1);
	        } else {
	            totalTax = (250000 * 0.05) + (500000 * 0.1) + ((taxableSalary - 1000000) * 0.2);
	        }

	        // Calculate cess
	        if(FLAG.equals("CESS")) {
	        if (taxableSalary > 250000) {
	            cess = (taxableSalary - 250000) * 0.02;
	        }
	        return cess;
	        }
	        else
	        	return totalTax;
		}
	
	
	@GetMapping("/{employeeId}/tax-deductions")
    public List<Object> getEmployeeTaxDeductions(@PathVariable String employeeId) {
    	ArrayList li=new ArrayList<>();
    	double tax=getTaxAmountDataByEmployeeId(employeeId,"TAX");
    	double cess=getTaxAmountDataByEmployeeId(employeeId,"CESS");
    	Optional<EmployeeInfoVo> List = employeeInfoService.getDataByEmployeeId(employeeId);
    	Map map=new HashMap<>();
    	map.put("employeeId", List.get().getEmployeeId());
    	map.put("firstName", List.get().getFirstName());
    	map.put("lastName", List.get().getLastName());
    	map.put("yearlySalary", List.get().getSalary()*12);
    	map.put("taxAmount", tax);
    	map.put("cessAmount", cess);
    	li.add(map);
    	return li;
    	
    }
}
