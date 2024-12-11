package com.example.CrudSpring.controller;

import com.example.CrudSpring.entity.Product;
import com.example.CrudSpring.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @RequestMapping("/")
    public String verPaginaInicial(Model model) {
        List<Product> listaProducts = productServices.listAll();
        model.addAttribute("listaProducts", listaProducts);
        return "index";
    }
}

