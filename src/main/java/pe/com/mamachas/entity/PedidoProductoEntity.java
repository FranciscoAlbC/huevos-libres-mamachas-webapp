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
//    @AttributeOverrides({
//            @AttributeOverride(name = "idPedido", column = @Column(name = "idPedido")),
//            @AttributeOverride(name = "idProducto", column = @Column(name = "idProducto")),
//    })
    private PedidoProductoId codigo;

    @Column(name = "cantidad")
    private float cantidad;

    @Column(name = "estado")
    private boolean estado;
}
