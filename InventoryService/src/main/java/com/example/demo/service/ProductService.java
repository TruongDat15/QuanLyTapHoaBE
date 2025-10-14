package com.example.demo.service;

import com.example.demo.dto.request.ProductRequest;
import com.example.demo.dto.response.ProductResponse;
import com.example.demo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    String addProduct(ProductRequest productRequest);
    Optional<ProductRequest> updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProduct(Integer productId);
}
