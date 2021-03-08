package kz.iitu.spring.demo_atm.service;

import kz.iitu.spring.demo_atm.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllSalariedEmployee();
    List<Employee> getAllHourlyEmployee();
    List<Employee> getAllCommissionEmployee();
    List<Employee> getAllSalariedCommission();
    void updateEmployeeFixedSalary(Employee employee);
}
