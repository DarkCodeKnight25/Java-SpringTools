package com.example.index;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
public class ControllerREST {
    @GetMapping("/")
    public String index(){
        log.info("Entrando a la ruta raíz");
        log.debug("MAS INFORMACION ");
        return "Hola bebecita, como estas";
    }
}
