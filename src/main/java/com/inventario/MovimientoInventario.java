package com.inventario;
import java.time.LocalDateTime;

public class MovimientoInventario {

    private String codigoProducto;
    private String tipo;
    private int cantidad;
    private LocalDateTime fecha;

    public MovimientoInventario(
            String codigoProducto,
            String tipo,
            int cantidad) {

        this.codigoProducto = codigoProducto;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = LocalDateTime.now();
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {

        return fecha +
                " | Producto: " + codigoProducto +
                " | " + tipo +
                " | Cantidad: " + cantidad;
    }
}
