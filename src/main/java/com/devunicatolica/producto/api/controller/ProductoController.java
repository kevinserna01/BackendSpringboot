package com.devunicatolica.producto.api.controller;

import com.devunicatolica.producto.api.model.Producto;
import com.devunicatolica.producto.api.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (value = "productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @GetMapping
    public List<Producto>listar(){
        return productoService.findAll();

    }


}


