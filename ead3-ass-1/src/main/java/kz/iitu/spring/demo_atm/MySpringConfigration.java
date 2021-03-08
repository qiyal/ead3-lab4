package kz.iitu.spring.demo_atm;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("kz.iitu.spring.demo_atm")
@PropertySource("/application.properties")
@EnableJpaRepositories(basePackages = "kz.iitu.spring.demo_atm.repository")
public class MySpringConfigration { }
