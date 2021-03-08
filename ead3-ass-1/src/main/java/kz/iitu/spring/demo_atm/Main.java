package kz.iitu.spring.demo_atm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySpringConfigration.class);
        PayrollSystem payrollSystem = context.getBean("payrollSystem", PayrollSystem.class);
        payrollSystem.start();

        context.registerShutdownHook();
    }
}
