----MySQL Database Configuration

Created table:employee_details

CREATE TABLE employee_details (
    employee_id VARCHAR(255) PRIMARY KEY, -- Unique identifier
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL, 
    -- Assuming email is unique for each employee
    phone_numbers TEXT, -- Store multiple phone numbers in a single column
    doj DATE NOT NULL, -- Date of Joining
    salary DECIMAL(10, 2) NOT NULL -- Salary with 2 decimal places for precision


swagger URL:

http://localhost:8080/swagger-ui.html
