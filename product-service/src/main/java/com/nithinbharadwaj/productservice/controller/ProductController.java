package com.nithinbharadwaj.productservice.controller;

import com.nithinbharadwaj.productservice.dto.ProductRequest;
import com.nithinbharadwaj.productservice.dto.ProductResponse;
import com.nithinbharadwaj.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest){
        boolean createStatus = productService.createProduct(productRequest);
        if(createStatus){
            return ResponseEntity.status(HttpStatus.CREATED).body("Created Product Successfully");
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

}
