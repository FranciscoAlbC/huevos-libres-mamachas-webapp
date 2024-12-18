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
@Entity(name = "OrdenCompraEntity")
@Table(name = "ordencompra")
public class OrdenCompraEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "montoTotalSinIGV")
    private float montoTotalSinIGV;

    @Column(name = "montoIGV")
    private float montoIGV;

    @Column(name = "montoTotalConIGV")
    private float montoTotalConIGV;

    @Column(name = "cotizacion")
    private byte[] cotizacion;

    @Column(name = "fechaPago")
    private LocalDate fechaPago;

    @Column(name = "medioPago")
    private String medioPago;

    @Column(name = "voucherPago")
    private byte[] voucherPago;

    @ManyToOne
    @JoinColumn(name = "codigoProveedor", referencedColumnName = "codigo", nullable = false)
    private ProveedorEntity proveedor;
}
