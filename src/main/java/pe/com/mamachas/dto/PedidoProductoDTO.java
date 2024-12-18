package pe.com.mamachas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.mamachas.entity.PedidoProductoId;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoProductoDTO {

    private PedidoProductoIdDTO codigo;
    private float cantidad;
    private boolean estado;

}
