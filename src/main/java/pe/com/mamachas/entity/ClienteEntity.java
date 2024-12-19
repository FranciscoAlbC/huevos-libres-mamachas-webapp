package pe.com.lasmamachas.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pe.com.lasmamachas.entity.base.BaseEntity2;

@SuperBuilder
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "ClienteEntity")
@Table(name = "cliente")
public class ClienteEntity extends BaseEntity2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nomCliente", nullable = true)
    private String nomCliente;

}
