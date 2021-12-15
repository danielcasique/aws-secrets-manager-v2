package com.casique.awssecretsmanagerv2.controllers;

import com.casique.awssecretsmanagerv2.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.casique.awssecretsmanagerv2.services.ProductService;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/productByName/{name}")
    public List<Product> getProductByName(@PathVariable String name)
    {
        return productService.findByName(name);
    }

    @GetMapping(value = "/product")
    public List<Product> getAll(){
        return productService.getAllProducts();
    }

    @PutMapping(value = "/product")
    public HttpStatus updateProduct(@RequestBody Product product){
        return productService.saveProduct(product) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @PostMapping(value = "/product")
    public HttpStatus insertProduct(@RequestBody Product product)
    {
        return productService.saveProduct(product) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }
}
