package front;
import funcionalidades.FuncionesBasicas;
import inventario.Productos;
import java.util.Scanner;

public class AgregarProducto {
    public void ejecutar(FuncionesBasicas funcionesBasicas, Scanner scanner) {
        System.out.print("Ingrese ID del producto: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese categoría del producto: ");
        String categoria = scanner.nextLine();
        System.out.print("Ingrese precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese cantidad disponible: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        Productos producto = new Productos(id, nombre, categoria, precio, cantidad);
        funcionesBasicas.agregarProducto(producto);
    }
}