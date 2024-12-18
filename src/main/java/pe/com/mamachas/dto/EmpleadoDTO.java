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
public class EmpleadoDTO extends BaseDTO  {

    private String nomEmpleado;
    private String apePaterno;
    private String apeMaterno;
    private String tipoDoc;
    private String nroDoc;
    private String rol;
    private LocalDate fechaContratacion;
    private String telefono;
    private String correo;
    private boolean estado;


}
