package kz.iitu.spring.demo_atm.controller;

import kz.iitu.spring.demo_atm.event.SalaryChangeEvent;
import kz.iitu.spring.demo_atm.models.Employee;
import kz.iitu.spring.demo_atm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public List<Employee> getAllSalariedEmployee() {
        return employeeService.getAllSalariedEmployee();
    }

    public List<Employee> getAllHourlyEmployee() {
        return employeeService.getAllHourlyEmployee();
    }

    public List<Employee> getAllCommissionEmployee() {
        return employeeService.getAllCommissionEmployee();
    }

    public List<Employee> getAllSalariedCommission() {
        return employeeService.getAllSalariedCommission();
    }

    public void updateEmployeeFixedSalary(Employee employee, Double oldSalary) {
        this.employeeService.updateEmployeeFixedSalary(employee);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employee, oldSalary));
    }
}
