package pe.com.mamachas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoInsumoDTO {

    private long codigo;
    private String nombre;
    private boolean estado;

}
