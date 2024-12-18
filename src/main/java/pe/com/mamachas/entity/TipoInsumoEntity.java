package pe.com.mamachas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "TipoInsumoEntity")
@Table(name = "tipoinsumo")
public class TipoInsumoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private boolean estado;
}
