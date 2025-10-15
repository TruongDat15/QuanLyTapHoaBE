package com.example.demo.entity;



import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;

    @Column(nullable = false)
    private String supplierName;

    private String phone;
    private String email;
    private String address;
    private String note;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<ImportProduct> importProducts;
}