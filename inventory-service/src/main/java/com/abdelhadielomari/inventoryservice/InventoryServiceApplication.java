package com.abdelhadielomari.inventoryservice;

import com.abdelhadielomari.inventoryservice.Reposetory.ProductReposetory;
import com.abdelhadielomari.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductReposetory productReposetory){
        return args -> {
            productReposetory.save(Product.builder()
                            .nom("p1")
                            .price(1000*Math.random()*100)
                    .build());
            productReposetory.save(Product.builder()
                    .nom("p2")
                    .price(1000*Math.random()*100)
                    .build());
        };
    }

}
