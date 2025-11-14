package com.devunicatolica.producto.api.controller;

import com.devunicatolica.producto.api.model.Producto;
import com.devunicatolica.producto.api.service.ProductoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "productos")

public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @GetMapping
    public List<Producto> listar() {
        return productoService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerporId(@PathVariable(name = "id") Long id) {
        Optional<Producto> producto = productoService.findById(id);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        Producto productoCreado = productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable(name = "id") Long id, @RequestBody Producto producto) {
        Producto productoactualizado = productoService.update(id, producto);
        if (productoactualizado != null) {
            return ResponseEntity.ok(productoactualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable(name = "id") Long id) {
        boolean eliminado = productoService.delete(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }
}


