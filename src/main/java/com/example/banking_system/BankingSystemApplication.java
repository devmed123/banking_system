package com.example.banking_system;

import com.example.banking_system.factories.Factoryimp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingSystemApplication.class, args);
    }
   @Bean
   public Factoryimp getFactoryimp(){
        return new Factoryimp();
   }
}
