package pe.com.mamachas.entity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import jakarta.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


@Entity(name = "DetalleVentaEntity")
@Table(name = "DetalleVenta")
public class DetalleVentaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "cantidad")
    private float cantidad;

    @Column(name = "precioUnitario")
    private float precioUnitario;

    @Column(name = "precioTotal")
    private float precioTotal;

    @Column(name = "montoTotalConIGV")
    private float montoTotalConIGV;

    @ManyToOne
    @JoinColumn(name="idVenta")
    private VentaEntity venta;
    
    @ManyToOne
    @JoinColumn(name="idProducto")
    private ProductoEntity producto;

    @Column(name = "estado")
    private boolean estado;
}
