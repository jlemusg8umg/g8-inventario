package com.inventario;

public class Main {

    public static void main(String[] args) {

        InventarioService inventario =
                new InventarioService();

        ReporteService reportes =
                new ReporteService();

        Proveedor proveedor1 =
                new Proveedor(
                        "PROV001",
                        "Tecnología GT",
                        "5555-1111",
                        "ventas@tecnologiagt.com"
                );

        Proveedor proveedor2 =
                new Proveedor(
                        "PROV002",
                        "Distribuidora Central",
                        "5555-2222",
                        "ventas@central.com"
                );

        Producto teclado =
                new Producto(
                        "P001",
                        "Teclado mecánico",
                        450,
                        10,
                        5,
                        Categoria.ELECTRONICA,
                        proveedor1
                );

        Producto mouse =
                new Producto(
                        "P002",
                        "Mouse inalámbrico",
                        150,
                        3,
                        5,
                        Categoria.ELECTRONICA,
                        proveedor1
                );

        Producto papel =
                new Producto(
                        "P003",
                        "Resma papel carta",
                        45,
                        50,
                        10,
                        Categoria.OFICINA,
                        proveedor2
                );

        Producto limpiador =
                new Producto(
                        "P004",
                        "Limpiador multiusos",
                        35,
                        0,
                        5,
                        Categoria.LIMPIEZA,
                        proveedor2
                );

        inventario.registrarProducto(teclado);
        inventario.registrarProducto(mouse);
        inventario.registrarProducto(papel);
        inventario.registrarProducto(limpiador);

        System.out.println();

        reportes.mostrarInventario(
                inventario.getProductos()
        );

        System.out.println();

        inventario.entradaStock(
                "P002",
                10
        );

        inventario.salidaStock(
                "P001",
                2
        );

        inventario.actualizarPrecio(
                "P003",
                48
        );

        System.out.println();

        reportes.mostrarProductosStockBajo(
                inventario.obtenerStockBajo()
        );

        System.out.println();

        System.out.println(
                "Valor total del inventario: Q"
                        + inventario.calcularValorInventario()
        );

        System.out.println();

        inventario.analizarInventario();

        System.out.println();

        reportes.mostrarMovimientos(
                inventario.getMovimientos()
        );
    }
}