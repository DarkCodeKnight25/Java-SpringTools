package com.example.CrudSpring.services;

import com.example.CrudSpring.entity.Product;
import com.example.CrudSpring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(){
        return productRepository.findAll();
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public Product get(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
