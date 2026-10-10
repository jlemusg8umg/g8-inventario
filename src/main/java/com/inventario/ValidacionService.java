package com.inventario;
import java.util.logging.Logger;

public class ValidacionService {

    private static final Logger LOGGER =
            Logger.getLogger(ValidacionService.class.getName());
    private static final String STOCK_INVALIDO = "Stock inválido";
    public boolean validarProducto(Producto producto) {

        if (producto == null) {
            System.out.println("Producto inválido");
            return false;
        }

        if (producto.getCodigo() == null || producto.getCodigo().isBlank()) {
            System.out.println("Código inválido");
            return false;
        }

        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            System.out.println("Nombre inválido");
            return false;
        }

        if (producto.getPrecio() < 0) {
            System.out.println("Precio inválido");
            return false;
        }

        if (producto.getStock() < 0) {
            LOGGER.warning(STOCK_INVALIDO);
            return false;
        }

        return true;
    }

    public boolean validarStock(int stock) {

        if (stock < 0) {
            LOGGER.warning(STOCK_INVALIDO);
            return false;
        }

        return true;
    }
}
