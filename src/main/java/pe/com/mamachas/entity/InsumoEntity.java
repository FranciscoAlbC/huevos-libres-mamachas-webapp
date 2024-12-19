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
@Entity(name = "InsumoEntity")
@Table(name = "insumo")
public class InsumoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idTipoInsumo", referencedColumnName = "codigo", nullable = false)
    private TipoInsumoEntity tipoInsumo;

    @Column(name = "stockMinimo")
    private float stockMinimo;

    @Column(name = "stock")
    private float stock;

    @Column(name = "estado")
    private boolean estado;
}
