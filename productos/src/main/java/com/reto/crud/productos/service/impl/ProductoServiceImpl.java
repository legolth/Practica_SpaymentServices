package com.reto.crud.productos.service.impl;

import com.reto.crud.productos.dto.ProductoDto;
import com.reto.crud.productos.entity.Producto;
import com.reto.crud.productos.exception.ResourceNotFoundException;
import com.reto.crud.productos.mapper.ProductoMapper;
import com.reto.crud.productos.repository.ProductoRepository;
import com.reto.crud.productos.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDto> listarProductos() {
        List<Producto> allProductos = productoRepository.findAll();
        return allProductos.stream().map((producto) -> ProductoMapper.toProductoDto(producto))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDto obtenerProductosPorNombre(String name) {
        Producto producto = productoRepository.findByNombre(name)
                .orElseThrow(()->
                        new ResourceNotFoundException("Persona no encontrada" + name));
        return ProductoMapper.toProductoDto(producto);
    }

    @Override
    public ProductoDto crearProducto(ProductoDto productoDto) {
        Producto producto = ProductoMapper.toProducto(productoDto);
        Producto SaveProducto = productoRepository.save(producto);
        return ProductoMapper.toProductoDto(SaveProducto);
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Persona no encontrada" + id));
        productoRepository.deleteById(id);

    }

    @Override
    public ProductoDto UpdateProducto(Long id, ProductoDto productoDto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada" + id)  );

        producto.setId(productoDto.getId());
        producto.setName(productoDto.getName());
        producto.setCreatedAt(productoDto.getCreatedAt());
        producto.setLabel(productoDto.getLabel());
        producto.setPrice(productoDto.getPrice());
        Producto updateproducto = productoRepository.save(producto);
        return ProductoMapper.toProductoDto(updateproducto);
    }
}
