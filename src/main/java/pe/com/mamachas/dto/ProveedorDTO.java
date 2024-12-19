package pe.com.mamachas.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorDTO {

    private int codigo;
    private String nomProveedor;
    private String ruc;
    private String productoProveedor;
    private String telefono;
    private String correo;
    private boolean estado;
}
