package com.mindsprint.springbootapp.controllers;

import com.mindsprint.springbootapp.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @GetMapping("{id}")
    public Product getProduct(@PathVariable int id){
        return  new Product(id,"ProductDemo",5678);
    }
}
