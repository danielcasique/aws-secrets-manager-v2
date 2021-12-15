package com.casique.awssecretsmanagerv2.services;

import com.casique.awssecretsmanagerv2.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.casique.awssecretsmanagerv2.repositories.ProductRepository;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository<Product> productRepository;

    @Transactional
    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    @Transactional
    public List<Product> findByName(String name){
        System.out.println("inside findByName method");
        return productRepository.findByName(name);
    }

    @Transactional
    public boolean saveProduct(Product product){
        return productRepository.save(product) != null;
    }
}
