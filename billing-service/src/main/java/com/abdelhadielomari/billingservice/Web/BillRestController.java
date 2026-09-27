package com.abdelhadielomari.billingservice.Web;


import com.abdelhadielomari.billingservice.Repository.BillRepository;
import com.abdelhadielomari.billingservice.Repository.ProductItemRepository;
import com.abdelhadielomari.billingservice.entities.Bill;
import com.abdelhadielomari.billingservice.entities.ProductItem;
import com.abdelhadielomari.billingservice.feign.CustomerServiceRestClient;
import com.abdelhadielomari.billingservice.feign.ProductServiceRestClient;
import com.abdelhadielomari.billingservice.models.Customer;
import com.abdelhadielomari.billingservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceRestClient customerServiceRestClient;
    @Autowired
    private ProductServiceRestClient productServiceRestClient;

    @GetMapping("/bills/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill=billRepository.findById(id).orElse(null);
        Customer customer=customerServiceRestClient.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        List<ProductItem> productItems=productItemRepository.findByBillId(id);
        productItems.forEach(productItem -> {
            Product product=productServiceRestClient.findProductById(productItem.getProductId());
            productItem.setProduct(product);
        });
        bill.setProductItems(productItems);
        billRepository.save(bill);
        return bill;


    }


}
