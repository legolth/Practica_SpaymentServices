package com.reto.crud.productos.dto;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductoDto {

    private Long id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Label cannot be null")
    private String label;
    @NotNull(message = "Price cannot be null")
    private Double price;

    private Date createdAt;


}
