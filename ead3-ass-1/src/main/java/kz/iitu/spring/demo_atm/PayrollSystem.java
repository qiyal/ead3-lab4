package kz.iitu.spring.demo_atm;

//import kz.iitu.spring.demo_atm.dao.EmployeeDao;
import kz.iitu.spring.demo_atm.controller.EmployeeController;
import kz.iitu.spring.demo_atm.models.Employee;
import kz.iitu.spring.demo_atm.service.EmployeeService;
import kz.iitu.spring.demo_atm.service.SalaryCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class PayrollSystem {
    private Scanner sc;
    @Autowired
    private SalaryCalculatorService salaryCalculatorService;
    @Autowired
    private EmployeeController employeeController;

    public PayrollSystem() {
        this.sc = new Scanner(System.in);
    }

    public void add10PercentSalaryForSalariedCommission() {
        List<Employee> employees = employeeController.getAllSalariedCommission();
        for (int i = 0; i < employees.size(); i++) {
            Double oldSalary = employees.get(i).getFixedSalary();
            employees.get(i).setFixedSalary(oldSalary * 1.1);
            employeeController.updateEmployeeFixedSalary(employees.get(i), oldSalary);
        }
    }

    private void changeSalaryForSalariedEmployee() {
        List<Employee> employees = employeeController.getAllSalariedEmployee();

        for (int i = 0; i < employees.size(); i++) {
            System.out.println(i + ") " + employees.get(i).getName() + " (id=" + employees.get(i).getId() + ")");
        }
        System.out.print("chose employee: ");
        Integer indexEmployee = sc.nextInt();
        Double oldSalary = employees.get(indexEmployee).getFixedSalary();
        System.out.print("input new salary: ");
        employees.get(indexEmployee).setFixedSalary(sc.nextDouble());

        employeeController.updateEmployeeFixedSalary(employees.get(indexEmployee), oldSalary);
    }

    private void changeSalaryForHourlyEmployee() {
        List<Employee> employees = employeeController.getAllHourlyEmployee();

        for (int i = 0; i < employees.size(); i++) {
            System.out.println(i + ") " + employees.get(i).getName() + " (id=" + employees.get(i).getId() + ")");
        }
        System.out.print("chose employee: ");
        Integer indexEmployee = sc.nextInt();
        Double oldSalary = employees.get(indexEmployee).getFixedSalary();
        System.out.print("input new salary hour: ");
        employees.get(indexEmployee).setHourRate(sc.nextDouble());

        salaryCalculatorService.calculateHourlyEmployeeSalary(employees.get(indexEmployee));
        employeeController.updateEmployeeFixedSalary(employees.get(indexEmployee), oldSalary);
    }

    private void changeSalaryForCommissionEmployee() {
        List<Employee> employees = employeeController.getAllCommissionEmployee();

        for (int i = 0; i < employees.size(); i++) {
            System.out.println(i + ") " + employees.get(i).getName() + " (id=" + employees.get(i).getId() + ")");
        }
        System.out.print("chose employee: ");
        Integer indexEmployee = sc.nextInt();
        Double oldSalary = employees.get(indexEmployee).getFixedSalary();
        System.out.print("input sale amount: ");
        Double saleAmount = sc.nextDouble();

        salaryCalculatorService.calculateSalaryCommissionEmployee(employees.get(indexEmployee), saleAmount);
        employeeController.updateEmployeeFixedSalary(employees.get(indexEmployee), oldSalary);
    }

    private void changeSalaryForSalariedCommissionEmployee() {
        List<Employee> employees = employeeController.getAllSalariedCommission();

        for (int i = 0; i < employees.size(); i++) {
            System.out.println(i + ") " + employees.get(i).getName() + " (id=" + employees.get(i).getId() + ")");
        }

        System.out.print("chose employee: ");
        Integer indexEmployee = sc.nextInt();
        Double oldSalary = employees.get(indexEmployee).getFixedSalary();
        System.out.print("input sale amount: ");
        Double saleAmount = sc.nextDouble();
        salaryCalculatorService.calculateSalarySalariedCommissionEmployee(employees.get(indexEmployee), saleAmount);
        employeeController.updateEmployeeFixedSalary(employees.get(indexEmployee), oldSalary);
    }

    public void start() {
        showMeu();
    }

    private void showMeu() {
        boolean isWord = true;
        while(isWord) {
            System.out.println("\nenter 1 - Adding 10% base salaries for all Salaried-Commission employees");
            System.out.println("enter 2 - change salary for Salaried employee");
            System.out.println("enter 3 - change salary for Hourly employee");
            System.out.println("enter 4 - change salary for Commission employee");
            System.out.println("enter 5 - change salary for Salaried-Commission employee");
            System.out.println("enter 0 - Exit Program");
            System.out.print("enter: ");
            String chose = sc.next();

            switch (chose) {
                case "1":
                    add10PercentSalaryForSalariedCommission();
                    break;
                case "2":
                    changeSalaryForSalariedEmployee();
                    break;
                case "3":
                    changeSalaryForHourlyEmployee();
                    break;
                case "4":
                    changeSalaryForCommissionEmployee();
                    break;
                case "5":
                    changeSalaryForSalariedCommissionEmployee();
                    break;
                case "0":
                    isWord = false;
                    break;
                default:
                    System.out.println("Invalid argument!");
            }
        }
    }
}
