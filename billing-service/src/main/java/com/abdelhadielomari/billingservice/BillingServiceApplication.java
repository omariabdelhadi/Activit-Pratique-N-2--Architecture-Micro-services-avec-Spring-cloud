package com.abdelhadielomari.billingservice;

import com.abdelhadielomari.billingservice.Repository.BillRepository;
import com.abdelhadielomari.billingservice.Repository.ProductItemRepository;
import com.abdelhadielomari.billingservice.entities.Bill;
import com.abdelhadielomari.billingservice.entities.ProductItem;
import com.abdelhadielomari.billingservice.models.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BillRepository billRepository, ProductItemRepository productItemRepository){
        return args -> {
            List<Long> customersIds=List.of(1L,2L);
            List<Long> productIds=List.of(1L,2L);
            customersIds.forEach(clientId->{
                Bill bill=new Bill();
                bill.setBillingDate(new Date());
                bill.setCustomerId(clientId);
                billRepository.save(bill);
                productIds.forEach(prId->{
                    ProductItem productItem=new ProductItem();
                    productItem.setPrice(1000*Math.random()*600);
                    productItem.setProductId(prId);
                    productItem.setQuantity(1+new Random().nextInt(20));
                    productItem.setBill(bill);
                    productItemRepository.save(productItem);

                });
            });

        };
    }

}
