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
@Entity(name = "PedidoProductoEntity")
@Table(name = "pedidoproducto")
public class PedidoProductoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

//    @ManyToOne
//    @JoinColumn(name = "idPedido", nullable = false);
//    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private ProductoEntity producto;

    @Column(name = "cantidad")
    private float cantidad;

    @Column(name = "estado")
    private boolean estado;

}
