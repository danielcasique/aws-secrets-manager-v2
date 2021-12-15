package com.casique.awssecretsmanagerv2.repositories;

import com.casique.awssecretsmanagerv2.entity.Product;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductRepository<P> extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
}
