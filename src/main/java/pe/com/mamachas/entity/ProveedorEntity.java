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

@Entity(name = "ProveedorEntity")
@Table(name = "Proveedor")
public class ProveedorEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "nomProveedor")
    private String nomProveedor;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "productoProveedor")
    private String productoProveedor;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "estado")
    private boolean estado;
}
