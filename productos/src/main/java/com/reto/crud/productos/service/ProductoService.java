package com.reto.crud.productos.service;

import com.reto.crud.productos.dto.ProductoDto;

import java.util.List;

public interface ProductoService {


    public List<ProductoDto> listarProductos();

    public ProductoDto obtenerProductosPorNombre(String id);

    public ProductoDto crearProducto(ProductoDto productoDto);

    public void eliminarProducto(Long id);

    public ProductoDto UpdateProducto(Long id, ProductoDto productoDto);


}
