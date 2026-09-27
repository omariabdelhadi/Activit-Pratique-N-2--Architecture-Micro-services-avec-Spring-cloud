package com.abdelhadielomari.billingservice.entities;

import com.abdelhadielomari.billingservice.models.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {
    @Id
    @GeneratedValue
    private Long id;
    private long productId;
    private int quantity;
    private double price;
    @JsonIgnore
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Bill bill;
    @Transient
    private Product product;
}
