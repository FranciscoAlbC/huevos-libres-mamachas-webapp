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

    @Column(name = "montototalsinigv")
    private float montoTotalSinIGV;

    @Column(name = "montoigv")
    private float montoIGV;

    @Column(name = "montototalconigv")
    private float montoTotalConIGV;

    //TODO
    //Hasta Merge de Sugey
//    @OneToOne
//    @JoinColumn(name="idpedido")
//    private PedidoEntity pedido;
//
//    @ManyToOne
//    @JoinColumn(name="idcliente")
//    private ClienteEntity cliente;
//
//    @OneToOne
//    @JoinColumn(name="idpago")
//    private PagoEntity pago;

    @ManyToOne
    @JoinColumn(name="idpromocion")
    private PromocionEntity promocion;

    @Column(name = "estado")
    private boolean estado;


}

