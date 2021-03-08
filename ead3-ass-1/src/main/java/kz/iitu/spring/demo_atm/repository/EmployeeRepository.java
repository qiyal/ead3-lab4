package kz.iitu.spring.demo_atm.repository;

import kz.iitu.spring.demo_atm.models.Employee;
import kz.iitu.spring.demo_atm.models.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> getEmployeesByEmplType(EmployeeType employeeType);
}
