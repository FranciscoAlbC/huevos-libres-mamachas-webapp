package pe.com.mamachas.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.mamachas.dto.base.BaseDTO;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PagoDTO extends BaseDTO {
    
    private LocalDate fechaPago;
    private float montoPago;
    private String metodoPago;
    private ComprobanteDTO comprobante;
    private boolean estado;    
}
