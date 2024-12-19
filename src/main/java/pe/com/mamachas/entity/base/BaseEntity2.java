package pe.com.mamachas.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
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
    private String apePaterno;

    @Column(name = "apeMaterno", length = 50, nullable = true)
    private String apeMaterno;

    @Column(name = "tipoDoc", length = 30, nullable = false)
    private String tipoDoc;

    @Column(name = "nroDoc", length = 30, nullable = false, unique = true)
    private String nroDoc;

    @Column(name = "direccion", length = 100, nullable = true)
    private String direccion;

    @Column(name = "telefono", length = 15, nullable = true)
    private String telefono;

    @Column(name = "correo", length = 100, nullable = true)
    private String correo;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
