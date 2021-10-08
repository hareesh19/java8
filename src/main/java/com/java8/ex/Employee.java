package com.java8.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Employee {

    int employeeId;
    Date dob;
    List<Address> employeeAddress;
    Role employeeRole;
    double employeeSalary;
    String firstName;
    String lastName;
    String department;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<Address> getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(List<Address> employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Role getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(Role employeeRole) {
        this.employeeRole = employeeRole;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public List<Employee> getAllEmp() {

        List<Employee> empList = new ArrayList<>();
        //empList.add(getEmp());
        Employee emp = new Employee(1000,  new Date(), null, null, 100.00, "cherry", "g","IT");
        Employee emp1 = new Employee(1001,  null, null, null, 1002.00, "Hareesh1", "marri1", "Account");
        Employee emp2 = new Employee(1002,  new Date(), null, null, 1001.00, "cherry", "marri2", "IT");
        Employee emp3 = new Employee(1002,  new Date(), null, null, 1001.00, "Hareesh12", "marri2", "HR");

        empList = Arrays.asList(emp, emp1, emp2,emp3);
        return empList;
    }

    public Employee getEmp() {
        Employee emp = new Employee(1000, new Date(), null, null, 100.00, "Cherry", "marri", "");
        emp = new Employee(1001,  null, null, null, 1002.00, "Hareesh1", "marri1", "");
        emp = new Employee(1002,  new Date(), null, null, 1001.00, "Hareesh12", "marri2", "");
        return emp;
    }

    public Employee(int employeeId, Date dob, List<Address> employeeAddress, Role employeeRole, double employeeSalary, String firstName, String lastName, String department) {
        this.employeeId = employeeId;
        this.dob = dob;
        this.employeeAddress = employeeAddress;
        this.employeeRole = employeeRole;
        this.employeeSalary = employeeSalary;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public Employee() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId &&
                Double.compare(employee.employeeSalary, employeeSalary) == 0 &&
                Objects.equals(dob, employee.dob) &&
                Objects.equals(employeeAddress, employee.employeeAddress) &&
                Objects.equals(employeeRole, employee.employeeRole) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, dob, employeeAddress, employeeRole, employeeSalary, firstName, lastName);
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

    public String getFirstName() {
        return firstName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", dob=" + dob +
                ", employeeAddress=" + employeeAddress +
                ", employeeRole=" + employeeRole +
                ", employeeSalary=" + employeeSalary +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
