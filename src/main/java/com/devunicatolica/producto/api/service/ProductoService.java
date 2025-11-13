package com.devunicatolica.producto.api.service;

import com.devunicatolica.producto.api.model.Producto;
import com.devunicatolica.producto.api.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private IProductRepository Iproducto;
    public List <Producto> findAll() {
        return Iproducto.findAll();

    }
}
