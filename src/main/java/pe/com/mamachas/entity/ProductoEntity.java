package pe.com.mamachas.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity(name = "ProductoEntity")
@Table(name = "Producto")
public class ProductoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "tipoHuevo")
    private String tipoHuevo;

    @Column(name = "medida")
    private String medida;

    @Column(name = "fechaRecoleccion")
    private Date fechaRecoleccion;

    @Column(name = "estado")
    private boolean estado;
}
