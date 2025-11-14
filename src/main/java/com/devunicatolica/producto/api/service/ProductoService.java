package com.devunicatolica.producto.api.service;

import com.devunicatolica.producto.api.model.Producto;
import com.devunicatolica.producto.api.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private IProductRepository Iproducto;


    public List<Producto> findAll() {
        return Iproducto.findAll();

    }

    public Optional<Producto> findById(Long id) {
        return Iproducto.findById(id);
    }


    public Producto save(Producto Producto) {
        return Iproducto.save(Producto);

    }

    public Producto update(Long id, Producto productoActualizado) {
        Optional<Producto> productoExistente = Iproducto.findById(id);
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setCantidad(productoActualizado.getCantidad());
            producto.setStock(productoActualizado.getStock());
            return Iproducto.save(producto);
        }
        return null;
    }

    public boolean delete(Long id) {
        if (Iproducto.existsById(id)) {
            Iproducto.deleteById(id);
            return true;
        }
        return false;
    }

}
