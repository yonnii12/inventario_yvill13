package front;
import funcionalidades.FuncionesBasicas;
import java.util.Scanner;

public class ActualizarProducto {
    public void ejecutar(FuncionesBasicas funcionesBasicas, Scanner scanner) {
        System.out.print("Ingrese ID del producto a actualizar: ");
        String idActualizar = scanner.nextLine();
        System.out.print("Ingrese nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese nueva categoría: ");
        String nuevaCategoria = scanner.nextLine();
        System.out.print("Ingrese nuevo precio: ");
        double nuevoPrecio = scanner.nextDouble();
        System.out.print("Ingrese nueva cantidad: ");
        int nuevaCantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        funcionesBasicas.actualizarProducto(idActualizar, nuevoNombre, nuevaCategoria, nuevoPrecio, nuevaCantidad);
    }
}
