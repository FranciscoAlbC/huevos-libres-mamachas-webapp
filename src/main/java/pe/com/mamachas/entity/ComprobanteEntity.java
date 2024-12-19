package pe.com.lasmamachas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.lasmamachas.entity.base.BaseEntity2;


@SuperBuilder
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "ComprobanteEntity")
@Table(name = "comprobante")
public class ComprobanteEntity extends BaseEntity2 implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "fechaFacturacion", nullable = true)
    private LocalDate fechaFacturacion;
    
    @Column(name = "tipoDocu", nullable = false)
    private String tipoDocu;

    @Column(name = "montoTotalSinIGV", nullable = false)
    private float montoTotalSinIGV;

    @Column(name = "montoIGV", nullable = false)
    private float montoIGV;

    @Column(name = "montoTotalConIGV", nullable = false)
    private float montoTotalConIGV;    

    @ManyToOne
    @JoinColumn(name = "idPedido", nullable = false)
    private PedidoEntity pedido;
    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private ClienteEntity cliente;   
}
