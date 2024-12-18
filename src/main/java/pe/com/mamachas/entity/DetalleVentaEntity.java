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
@Table(name = "detalleventa")
public class DetalleVentaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "cantidad")
    private float cantidad;

    @Column(name = "preciounitario")
    private float precioUnitario;

    @Column(name = "preciototal")
    private float precioTotal;

    @ManyToOne
    @JoinColumn(name="idventa")
    private VentaEntity venta;
    
    @ManyToOne
    @JoinColumn(name="idproducto")
    private ProductoEntity producto;

    @Column(name = "estado")
    private boolean estado;
}
