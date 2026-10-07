package com.inventario;

import java.util.ArrayList;
import java.util.List;

public class InventarioService {

    private List<Producto> productos = new ArrayList<>();
    private List<MovimientoInventario> movimientos = new ArrayList<>();

    private ValidacionService validacionService = new ValidacionService();

    public void registrarProducto(Producto producto) {

        if (!validacionService.validarProducto(producto)) {
            return;
        }

        Producto existente = buscarProducto(producto.getCodigo());

        if (existente != null) {
            System.out.println("El producto ya existe");
            return;
        }

        productos.add(producto);

        movimientos.add(
                new MovimientoInventario(
                        producto.getCodigo(),
                        "ENTRADA INICIAL",
                        producto.getStock()
                )
        );

        System.out.println("Producto registrado correctamente");
    }

    public Producto buscarProducto(String codigo) {

        for (Producto producto : productos) {

            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }

        return null;
    }

    public void entradaStock(String codigo, int cantidad) {

        Producto producto = buscarProducto(codigo);

        if (producto == null) {
            System.out.println("Producto no encontrado");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("Cantidad inválida");
            return;
        }

        producto.setStock(
                producto.getStock() + cantidad
        );

        movimientos.add(
                new MovimientoInventario(
                        codigo,
                        "ENTRADA",
                        cantidad
                )
        );

        System.out.println("Stock actualizado");
    }

    public void salidaStock(String codigo, int cantidad) {

        Producto producto = buscarProducto(codigo);

        if (producto == null) {
            System.out.println("Producto no encontrado");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("Cantidad inválida");
            return;
        }

        if (producto.getStock() < cantidad) {
            System.out.println("Stock insuficiente");
            return;
        }

        producto.setStock(
                producto.getStock() - cantidad
        );

        movimientos.add(
                new MovimientoInventario(
                        codigo,
                        "SALIDA",
                        cantidad
                )
        );

        System.out.println("Stock actualizado");

        System.out.println("Stock actualizado");
    }

    public void actualizarPrecio(
            String codigo,
            double nuevoPrecio) {

        Producto producto = buscarProducto(codigo);

        if (producto == null) {
            System.out.println("Producto no encontrado");
            return;
        }

        if (nuevoPrecio < 0) {
            System.out.println("Precio inválido");
            return;
        }

        producto.setPrecio(nuevoPrecio);

        System.out.println("Precio actualizado");
    }

    public void eliminarProducto(String codigo) {

        Producto producto = buscarProducto(codigo);

        if (producto == null) {
            System.out.println("Producto no encontrado");
            return;
        }

        productos.remove(producto);

        System.out.println("Producto eliminado");
    }

    public List<Producto> obtenerStockBajo() {

        List<Producto> resultado = new ArrayList<>();

        for (Producto producto : productos) {

            if (producto.getStock() <= producto.getStockMinimo()) {
                resultado.add(producto);
            }
        }

        return resultado;
    }

    public List<Producto> buscarPorCategoria(
            Categoria categoria) {

        List<Producto> resultado = new ArrayList<>();

        for (Producto producto : productos) {

            if (producto.getCategoria() == categoria) {
                resultado.add(producto);
            }
        }

        return resultado;
    }

    public double calcularValorInventario() {

        double total = 0;

        for (Producto producto : productos) {

            total =
                    total +
                            producto.getPrecio()
                                    * producto.getStock();
        }

        return total;
    }

    public void analizarInventario() {

        for (Producto producto : productos) {

            if (producto.getStock() == 0) {

                System.out.println(
                        producto.getNombre()
                                + " SIN EXISTENCIAS"
                );

            } else {

                if (producto.getStock()
                        <= producto.getStockMinimo()) {

                    System.out.println(
                            producto.getNombre()
                                    + " STOCK BAJO"
                    );

                } else {

                    if (producto.getStock() > 100) {

                        System.out.println(
                                producto.getNombre()
                                        + " SOBRE STOCK"
                        );

                    } else {

                        System.out.println(
                                producto.getNombre()
                                        + " STOCK NORMAL"
                        );
                    }
                }
            }
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<MovimientoInventario> getMovimientos() {
        return movimientos;
    }
}