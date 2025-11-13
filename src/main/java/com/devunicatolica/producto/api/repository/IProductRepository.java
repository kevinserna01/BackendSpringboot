package com.devunicatolica.producto.api.repository;

import com.devunicatolica.producto.api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository <Producto, Long> {

}
