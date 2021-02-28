package kz.iitu.spring.demo_atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class DemoAtmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAtmApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySpringConfigration.class);
        PayrollSystem payrollSystem = context.getBean("payrollSystem", PayrollSystem.class);
        payrollSystem.start();

        context.registerShutdownHook();
    }

}
