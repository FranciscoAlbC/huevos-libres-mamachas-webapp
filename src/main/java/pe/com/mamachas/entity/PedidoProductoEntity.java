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

    @EmbeddedId
    private PedidoProductoId codigo;

    //todo
//    @ManyToOne
//    @MapsId("IdPedido")
//    @JoinColumn(name="idPedido", referencedColumnName = "codigo")
//    private PedidoEntity pedido;

    @ManyToOne
    @MapsId("IdProducto")
    @JoinColumn(name = "idProducto", referencedColumnName = "codigo")
    private ProductoEntity producto;

    @Column(name = "cantidad")
    private float cantidad;

    @Column(name = "estado")
    private boolean estado;
}
