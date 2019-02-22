package com.epam.producing.testProject.repository;

import com.epam.producing.testProject.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase (EmployeRepository repository) {
        return args -> {
            log.info("PreLoading" + repository.save(new Employee("Bill","admin")));
            log.info("PreLoading" + repository.save(new Employee("Nick","user")));
        };
    }
}
