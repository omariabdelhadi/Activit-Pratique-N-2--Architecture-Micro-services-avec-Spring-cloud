package com.abdelhadielomari.inventoryservice.Reposetory;

import com.abdelhadielomari.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductReposetory extends JpaRepository<Product,Long> {
}
