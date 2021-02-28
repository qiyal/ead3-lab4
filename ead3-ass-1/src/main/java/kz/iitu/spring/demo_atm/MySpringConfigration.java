package kz.iitu.spring.demo_atm;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("kz.iitu.spring.demo_atm")
@PropertySource("/application.properties")
public class MySpringConfigration { }
