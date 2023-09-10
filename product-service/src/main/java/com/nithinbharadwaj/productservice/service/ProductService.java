package com.nithinbharadwaj.productservice.service;


import com.nithinbharadwaj.productservice.dto.ProductRequest;
import com.nithinbharadwaj.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    boolean createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

}
