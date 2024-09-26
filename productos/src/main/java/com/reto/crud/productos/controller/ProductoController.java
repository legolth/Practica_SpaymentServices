package com.reto.crud.productos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.reto.crud.productos.dto.ProductoDto;
import com.reto.crud.productos.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;


    @PostMapping
    public ResponseEntity<ProductoDto> crearProducto(@Valid @RequestBody ProductoDto productoDto) {
        ProductoDto saveProductoDto = productoService.crearProducto(productoDto);
        return new ResponseEntity<>(saveProductoDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDto>> listarProductos() {
        List<ProductoDto> consultaProductoDto = productoService.listarProductos();
        return ResponseEntity.ok(consultaProductoDto);
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProductoDto> obtenerProductoPorId(@PathVariable("name") String name) {
        ProductoDto ProductoDtoId = productoService.obtenerProductosPorNombre(name);
        return ResponseEntity.ok(ProductoDtoId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.ok("Producto eliminada exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> UpdateProducto(@PathVariable("id") Long ProductoId,
                                                    @RequestBody ProductoDto ProductoDto ) {
        ProductoDto updateProductoDto = productoService.UpdateProducto(ProductoId,ProductoDto);
        return ResponseEntity.ok(updateProductoDto);
    }



}
