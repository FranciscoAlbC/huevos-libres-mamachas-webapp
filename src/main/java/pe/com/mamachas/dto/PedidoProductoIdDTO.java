package pe.com.mamachas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoProductoIdDTO {

    private Integer idPedido;
    private Integer idProducto;

}
