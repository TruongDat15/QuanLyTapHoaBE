package com.example.demo.service.impl;

import com.example.demo.dto.request.ProductRequest;
import com.example.demo.dto.response.ProductResponse;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;




@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductResponse.builder()
                        .productName(product.getProductName())
                        .categoryName(product.getCategory() != null ? product.getCategory().getCategoryName() : null)
                        .unit(product.getUnit())
                        .barcode(product.getBarcode())
                        .sellingPrice(product.getSellingPrice())
                        .quantityInStock(product.getQuantityInStock())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public String addProduct(ProductRequest productRequest) {
        return "";
    }

    @Override
    public Optional<ProductRequest> updateProduct(Integer productId, ProductRequest productRequest) {
        return Optional.empty();
    }


//    public String addProduct(ProductRequest productRequest) {
//
//        if(productRepository.existsByBarcode(productRequest.getBarcode())){
//            throw new RuntimeException("Ma barcode da ton tai");
//        }
//        Optional<Category> category = categoryRepository.findById(productRequest.getCategoryId());
//        if(category.isEmpty()){
//            throw new RuntimeException("Khong tim thay category voi id: " + productRequest.getCategoryId());
//        }
//        Product product = Product.builder()
//                .productName(productRequest.getProductName())
//                .unit(productRequest.getUnit())
//                .barcode(productRequest.getBarcode())
//                .sellingPrice(productRequest.getSellingPrice())
//                .costOfCapital(productRequest.getCostOfCapital())
//                .quantityInStock(productRequest.getQuantityInStock())
//                .isActive(productRequest.getIsActive())
//                .category(category.get())
//                .build();
//
//
//                productRepository.save(product);
//                return "Them san pham thanh cong";
//    }


    @Override
    public void deleteProduct(Integer productId) {

    }


}
