package pe.com.mamachas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenCompraDTO {

    private long codigo;
    private LocalDate fecha;
    private boolean estado;
    private float montoTotalSinIGV;
    private float montoIGV;
    private float montoTotalConIGV;
    private byte[] cotizacion;
    private LocalDate fechaPago;
    private String medioPago;
    private byte[] voucherPago;

    private ProveedorDTO proveedor;

}
