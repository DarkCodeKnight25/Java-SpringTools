package com.example.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerHello {

    @GetMapping("/hello")
    public String helloWorld(
        @RequestParam(name = "nombre", required = false, defaultValue = "World")
        String nombre, Model model){
            model.addAttribute("nombre", nombre);
        return "hello";
    }
}
