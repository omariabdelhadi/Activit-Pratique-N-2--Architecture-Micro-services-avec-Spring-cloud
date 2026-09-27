package com.abdelhadielomari.customerservice.Reposetory;

import com.abdelhadielomari.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestResource
public interface CustomerReposetory extends JpaRepository<Customer,Long> {
}
