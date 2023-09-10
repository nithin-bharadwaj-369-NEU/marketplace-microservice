package com.nithinbharadwaj.productservice.service;

import com.nithinbharadwaj.productservice.dto.ProductRequest;
import com.nithinbharadwaj.productservice.dto.ProductResponse;
import com.nithinbharadwaj.productservice.model.Product;
import com.nithinbharadwaj.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public boolean createProduct(ProductRequest productRequest) {
        Product product = Product.builder().name(productRequest.getName())
                            .description(productRequest.getDescription()).price(productRequest.getPrice()).build();

        productRepository.save(product);
        log.info("Product Saved: {}", product.getId());
        return true;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> mapToProductResponse(product)).toList();
    }

    public ProductResponse mapToProductResponse(Product p){
        return ProductResponse.builder().id(p.getId()).name(p.getName()).description(p.getDescription()).price(p.getPrice()).build();
    }

}
