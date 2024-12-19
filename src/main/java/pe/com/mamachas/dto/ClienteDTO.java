package pe.com.lasmamachas.dto;

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
public class ClienteDTO extends BaseDTO {
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String tipoDoc;
    private String nroDoc;
    private String direccion;
    private String telefono;
    private String correo;
    private boolean estado;

}
