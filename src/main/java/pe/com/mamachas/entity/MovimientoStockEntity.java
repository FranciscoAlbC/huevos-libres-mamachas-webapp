package pe.com.mamachas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "MovimientoStockEntity")
@Table(name = "movimientostock")
public class MovimientoStockEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "cantidad")
    private float cantidad;

    @Column(name = "estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "idInsumo", nullable = false)
    private InsumoEntity insumo;

    @ManyToOne
    @JoinColumn(name = "idDetalleOrdenCompra", nullable = false)
    private DetalleOrdenCompraEntity detalleOrdenCompra;
}
