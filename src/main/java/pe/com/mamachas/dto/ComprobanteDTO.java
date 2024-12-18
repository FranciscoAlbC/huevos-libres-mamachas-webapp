package pe.com.lasmamachas.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.lasmamachas.dto.base.BaseDTO;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ComprobanteDTO extends BaseDTO{
    
    private LocalDate fechaFacturacion;
    private String tipoDocu;
    private float montoTotalSinIGV;
    private float montoIGV;
    private float montoTotalConIGV;
    private PedidoDTO pedido;
    private ClienteDTO cliente; 
    private boolean estado;
}
