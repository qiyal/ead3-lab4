package kz.iitu.spring.demo_atm.handler;

import kz.iitu.spring.demo_atm.event.SalaryChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SalaryChangeEventHandler implements ApplicationListener<SalaryChangeEvent> {

    @Override
    public void onApplicationEvent(SalaryChangeEvent salaryChangeEvent) {
        System.out.println("\nSalaryChangeEventHandler.onApplicationEvent");
        System.out.println("Salary update: " + salaryChangeEvent.getEmployee().getFixedSalary());
        System.out.println("Salary old:    " + salaryChangeEvent.getOldSalary());
        System.out.println("Employee:      " + salaryChangeEvent.getEmployee());
    }
}
