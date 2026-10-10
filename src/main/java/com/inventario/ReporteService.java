package com.inventario;

import java.util.List;
import java.util.logging.Logger;



public class ReporteService {
    private static final Logger LOGGER =
            Logger.getLogger(ReporteService.class.getName());
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


    public void mostrarMovimientos(List<MovimientoInventario> movimientos) {
        LOGGER.info("========= MOVIMIENTOS =========");

        for (MovimientoInventario movimiento : movimientos) {
            LOGGER.info(movimiento.toString());
        }
    }
}
