package com.reto.crud.productos.mapper;

import com.reto.crud.productos.dto.ProductoDto;
import com.reto.crud.productos.entity.Producto;

public class ProductoMapper {

    public static ProductoDto toProductoDto(Producto producto) {
        return new ProductoDto(producto.getId(),
                producto.getName(),
                producto.getLabel(),
                producto.getPrice(),
                producto.getCreatedAt()
        );
    }

    public static Producto toProducto(ProductoDto productoDto) {
        return new Producto(productoDto.getId(),
                productoDto.getName(),
                productoDto.getLabel(),
                productoDto.getPrice(),
                productoDto.getCreatedAt()
        );
    }



}
