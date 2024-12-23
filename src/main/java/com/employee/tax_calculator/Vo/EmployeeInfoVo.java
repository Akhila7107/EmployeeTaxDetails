package com.employee.tax_calculator.Vo;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name="employee_details")
public class EmployeeInfoVo {

	    @Id
	    @Column(name = "employeeId")
	    private String employeeId;

	    @Column(name = "firstName", nullable = false)
	    private String firstName;

	    @Column(name = "lastName", nullable = false)
	    private String lastName;

	    @Column(name = "email", unique = true, nullable = false)
	    private String email;

	    @Column(name = "phoneNumbers")
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

	    public String getPhoneNumbers() {
	        return phoneNumbers;
	    }

	    public void setPhoneNumbers(String phoneNumbers) {
	        this.phoneNumbers = phoneNumbers;
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
