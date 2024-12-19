package pe.com.mamachas.entity;

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
import pe.com.mamachas.entity.base.BaseEntity2;

@SuperBuilder
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "PagoEntity")
@Table(name = "pago")
public class PagoEntity extends BaseEntity2 implements Serializable{

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    @Column(name = "fechaPago", nullable = false)
    private LocalDate fechaPago;

    @Column(name = "montoPago", nullable = false)
    private float montoPago;

    @Column(name = "metodoPago", nullable = false)
    private String metodoPago;
    
    @ManyToOne
    @JoinColumn(name = "idComprobante", nullable = false)
    private ComprobanteEntity comprobante;    
}
