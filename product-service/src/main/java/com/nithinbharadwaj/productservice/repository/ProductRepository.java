package com.nithinbharadwaj.productservice.repository;

import com.nithinbharadwaj.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
