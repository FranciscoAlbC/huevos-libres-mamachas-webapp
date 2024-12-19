package pe.com.mamachas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.mamachas.entity.base.BaseEntity2;

@SuperBuilder
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "EmpleadoEntity")
@Table(name = "empleado")
public class EmpleadoEntity extends BaseEntity2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codigo")
    private long codigo;

    @Column(name = "nomEmpleado", nullable = true)
    private String nomEmpleado;

    @Column(name = "rol", nullable = true)
    private String rol;

    @Column(name = "fechaContratacion", nullable = true)
    private LocalDate fechaContratacion;


}
