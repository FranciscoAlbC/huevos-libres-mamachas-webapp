package pe.com.lasmamachas.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity2 {

    @Column(name = "apePaterno", length = 50, nullable = true)
    @NotEmpty
    private String apePaterno;

    @Column(name = "apeMaterno", length = 50, nullable = true)
    @NotEmpty
    private String apeMaterno;

    @Column(name = "tipoDoc", length = 30, nullable = false)
    @NotEmpty
    private String tipoDoc;

    @Column(name = "nroDoc", length = 30, nullable = false, unique = true)
    @NotEmpty
    private String nroDoc;

    @Column(name = "direccion", length = 100, nullable = true)
    @NotEmpty
    private String direccion;

    @Column(name = "telefono", length = 15, nullable = true)
    @NotEmpty
    private String telefono;

    @Column(name = "correo", length = 100, nullable = true)
    @NotEmpty
    private String correo;

    @Column(name = "estado", nullable = false)
    @NotEmpty
    private Boolean estado;
}
