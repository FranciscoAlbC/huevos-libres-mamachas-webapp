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
public class PedidoDTO extends BaseDTO{
    private LocalDate fechaPedido;
    private boolean estado;    
}