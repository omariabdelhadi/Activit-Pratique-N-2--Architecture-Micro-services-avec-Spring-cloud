package com.abdelhadielomari.billingservice.feign;

import com.abdelhadielomari.billingservice.models.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductServiceRestClient {
    @GetMapping("/products/{id}")
    @CircuitBreaker(name = "inventory-service",fallbackMethod = "getDefaultProduct")
    Product findProductById(@PathVariable Long id);

    default Product getDefaultProduct(Long id,Exception exception){
        exception.printStackTrace();
        Product product=new Product();
        product.setId(id);
        product.setNom("default nom");
        product.setPrice(0);

        return product;
    }
}
