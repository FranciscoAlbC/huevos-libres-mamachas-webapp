package pe.com.mamachas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsumoDTO {

    private long codigo;
    private String nombre;
    private TipoInsumoDTO tipoInsumo;
    private float stockMinimo;
    private float stock;
    private boolean estado;

}
