package pe.com.mamachas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoStockDTO {

    private Long codigo;
    private LocalDate fecha;
    private String tipo;
    private float cantidad;
    private boolean estado;
    private InsumoDTO insumo;
    private DetalleOrdenCompraDTO detalleOrdenCompra;

}
