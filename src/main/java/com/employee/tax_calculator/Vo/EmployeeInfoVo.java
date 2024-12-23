package com.employee.tax_calculator.Vo;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




@Entity
@Table(name="employee_details")
public class EmployeeInfoVo {

	
	    @Id
	    @Column(name = "employee_id")
	    private String employeeId;

	    @Column(name = "first_name", nullable = false)
	    private String firstName;

	    @Column(name = "last_name", nullable = false)
	    private String lastName;

	    @Column(name = "email", unique = true, nullable = false)
	    private String email;

	    @Column(name = "phone_numbers")
	    private String phoneNumbers; 

	    @Column(name = "doj", nullable = false)
	    private Date doj;

	    @Column(name = "salary", nullable = false, precision = 10, scale = 2)
	    private Double salary;

	    // Getters and Setters

	    public String getEmployeeId() {
	        return employeeId;
	    }

	    public void setEmployeeId(String employeeId) {
	        this.employeeId = employeeId;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setPhoneNumbers(List<String> phoneNumbers) {
	        try {
	            ObjectMapper objectMapper = new ObjectMapper();
	            this.phoneNumbers = objectMapper.writeValueAsString(phoneNumbers); 
	        } catch (JsonProcessingException e) {
	            // Handle exception (e.g., log the error)
	            e.printStackTrace();
	        }
	    }

	    public List<String> getPhoneNumbers() {
	        try {
	            ObjectMapper objectMapper = new ObjectMapper();
	            return objectMapper.readValue(this.phoneNumbers, List.class);
	        } catch (JsonProcessingException e) {
	            // Handle exception (e.g., log the error)
	            e.printStackTrace();
	            return null; // Or handle the error differently
	        }
	    }

	    public Date getDoj() {
	        return doj;
	    }

	    public void setDoj(Date doj) {
	        this.doj = doj;
	    }

	    public Double getSalary() {
	        return salary;
	    }

	    public void setSalary(Double salary) {
	        this.salary = salary;
	    }

}
