package pe.com.mamachas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrdenCompraDTO {

    private long codigo;
    private float cantidad;
    private float precioUnitario;
    private float precioTotal;
    private boolean estado;
    private OrdenCompraDTO ordenCompra;

}
