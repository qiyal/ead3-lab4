package kz.iitu.spring.demo_atm.service.impl;

import kz.iitu.spring.demo_atm.event.SalaryChangeEvent;
import kz.iitu.spring.demo_atm.models.Employee;
import kz.iitu.spring.demo_atm.models.EmployeeType;
import kz.iitu.spring.demo_atm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import kz.iitu.spring.demo_atm.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllSalariedEmployee() {
        return employeeRepository.getEmployeesByEmplType(EmployeeType.SALARIED);
    }

    @Override
    public List<Employee> getAllHourlyEmployee() {
        return employeeRepository.getEmployeesByEmplType(EmployeeType.HOURLY);
    }

    @Override
    public List<Employee> getAllCommissionEmployee() {
        return employeeRepository.getEmployeesByEmplType(EmployeeType.COMMISION);
    }

    @Override
    public List<Employee> getAllSalariedCommission() {
        return employeeRepository.getEmployeesByEmplType(EmployeeType.SALARIED_COMMISION);
    }

    @Override
    public void updateEmployeeFixedSalary(Employee employee) {
        employeeRepository.save(employee);
    }
}
