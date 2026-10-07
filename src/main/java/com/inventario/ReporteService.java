package com.inventario;

import java.util.List;
public class ReporteService {
    public void mostrarInventario(
            List<Producto> productos) {

        System.out.println(
                "========= INVENTARIO ========="
        );

        for (Producto producto : productos) {

            System.out.println(
                    producto.getCodigo()
                            + " | "
                            + producto.getNombre()
                            + " | Stock: "
                            + producto.getStock()
                            + " | Q"
                            + producto.getPrecio()
            );
        }
    }

    public void mostrarProductosStockBajo(
            List<Producto> productos) {

        System.out.println(
                "===== PRODUCTOS CON STOCK BAJO ====="
        );

        for (Producto producto : productos) {

            System.out.println(
                    producto.getCodigo()
                            + " | "
                            + producto.getNombre()
                            + " | Stock: "
                            + producto.getStock()
            );
        }
    }

    public void mostrarMovimientos(
            List<MovimientoInventario> movimientos) {

        System.out.println(
                "========= MOVIMIENTOS ========="
        );

        for (MovimientoInventario movimiento : movimientos) {
            System.out.println(movimiento);
        }
    }
}
