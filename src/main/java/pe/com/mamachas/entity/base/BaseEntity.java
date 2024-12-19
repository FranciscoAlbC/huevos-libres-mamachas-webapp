package pe.com.lasmamachas.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
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
public class BaseEntity {

    @Column(name = "nombre", length = 50,nullable = false)
    @NotEmpty
    private String nombre;
    @Column(name = "estado",nullable = false)
    @NotEmpty
    private boolean estado;
}
