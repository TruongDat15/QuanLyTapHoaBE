package com.example.demo.controller;

import com.example.demo.dto.request.ProductRequest;
import com.example.demo.dto.response.ProductResponse;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final com.example.demo.repository.ProductRepository productRepository;

    @GetMapping
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProducts();
    }
    @GetMapping("/hello")
    public String sayHi(){
        System.out.println("Hello");
        return "Hello hello";
    }


    @GetMapping("/barcode/{barcode}")
    public ResponseEntity<?> getByBarcode(@PathVariable String barcode) {
        Optional<Product> product = productRepository.findByBarcode(barcode);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Product not found", "barcode", barcode));
        }

        Product p = product.get();
        Map<String, Object> response = new HashMap<>();
        response.put("productId", p.getProductId());
        response.put("productName", p.getProductName());
        response.put("barcode", p.getBarcode());
        response.put("price", p.getSellingPrice());
        response.put("quantityInStock", p.getQuantityInStock());
        response.put("categoryName", p.getCategory().getCategoryName());

        return ResponseEntity.ok(response);
    }

}
