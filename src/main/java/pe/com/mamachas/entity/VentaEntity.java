package pe.com.mamachas.entity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import java.util.Date;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


@Entity(name = "VentaEntity")
@Table(name = "Venta")

public class VentaEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "montoTotalSinIGV")
    private float montoTotalSinIGV;

    @Column(name = "montoIGV")
    private float montoIGV;

    @Column(name = "montoTotalConIGV")
    private float montoTotalConIGV;

   /*  @OneToOne
    @JoinColumn(name="idPedido")
    private PedidoEntity pedido;
    
    @ManyToOne
    @JoinColumn(name="idCliente")
    private ClienteEntity cliente;

    @OneToOne
    @JoinColumn(name="idPago")
    private PagoEntity pago; */

    @ManyToOne
    @JoinColumn(name="idPromocion")
    private PromocionEntity promocion;

    @Column(name = "estado")
    private boolean estado;


}

