package com.abdelhadielomari.customerservice;

import com.abdelhadielomari.customerservice.Reposetory.CustomerReposetory;
import com.abdelhadielomari.customerservice.config.CustomerConfigParams;
import com.abdelhadielomari.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerReposetory customerReposetory){
        return args -> {
            customerReposetory.save(Customer.builder().
                    name("Mohamed").email("med@gmail.com").build());
            customerReposetory.save(Customer.builder().
                    name("amin").email("amin@gmail.com").build());
        };
    }

}
