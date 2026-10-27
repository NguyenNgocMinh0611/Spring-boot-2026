package com.springmasterclass.study.bai5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // 1 category có nhiều sản phẩm
    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @Builder.Default
    private List<Product> products = new ArrayList<>();

    // helper method
    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this);
    }

    //
    public void removeProduct(Product product) {
        products.remove(product);
        product.setCategory(null);
    }

}
