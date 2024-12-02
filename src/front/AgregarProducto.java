package front;

import funcionalidades.FuncionesBasicas;
import inventario.Productos;

import java.util.Scanner;

public class AgregarProducto {
    public void ejecutar(FuncionesBasicas funcionesBasicas, Scanner scanner) {
        System.out.print("Ingrese ID del producto: ");
        String id = scanner.nextLine();
        if (funcionesBasicas.buscarProductoPorId(id) != null) {
            System.out.println("Error: Ya existe un producto con el ID: " + id);
            return;
        }
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese categoría del producto: ");
        String categoria = scanner.nextLine();
        double precio;
        while (true) {
            System.out.print("Ingrese precio del producto: ");
            try {
                precio = Double.parseDouble(scanner.nextLine());
                if (precio < 0) {
                    System.out.println("El precio no puede ser negativo. Intente nuevamente.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: El precio debe ser un número válido. Intente nuevamente.");
            }
        }

        int cantidad;
        while (true) {
            System.out.print("Ingrese cantidad disponible: ");
            try {
                cantidad = Integer.parseInt(scanner.nextLine());
                if (cantidad < 0) {
                    System.out.println("La cantidad no puede ser negativa. Intente nuevamente.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: La cantidad debe ser un número entero válido. Intente nuevamente.");
            }
        }
        Productos producto = new Productos(id, nombre, categoria, precio, cantidad);
        funcionesBasicas.agregarProducto(producto);
    }
}