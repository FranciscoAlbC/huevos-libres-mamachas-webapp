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
@Entity(name = "DetalleOrdenCompraEntity")
@Table(name = "detalleordencompra")
public class DetalleOrdenCompraEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "cantidad")
    private float cantidad;

    @Column(name = "precioUnitario")
    private float precioUnitario;

    @Column(name = "precioTotal")
    private float precioTotal;

    @Column(name = "estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "idOrdenCompra", nullable = false)
    private OrdenCompraEntity ordenCompra;

}
