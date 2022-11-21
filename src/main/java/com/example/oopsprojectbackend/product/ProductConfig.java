package com.example.oopsprojectbackend.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args ->{
//            Student shubham = new Student(
//                    1L,
//                    "Shubham Goyal",
//                    "spiken23@gmail.com",
//                    LocalDate.of(2003, Month.OCTOBER, 12)
//            );
//
//            Student jatin = new Student(
//                    "Jatin Vijay",
//                    "jatinvijay@gmail.com",
//                    LocalDate.of(2002, Month.FEBRUARY, 28)
//            );
//
//            repository.saveAll(List.of(shubham, jatin));
        };
    }
}
