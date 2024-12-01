package front;
import funcionalidades.FuncionesBasicas;
import inventario.Productos;
import java.util.List;
import java.util.Scanner;

public class SubMenuBuscar {
    public void ejecutar(FuncionesBasicas funcionesBasicas, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\nSubmenú de Búsqueda");
            System.out.println("1. Buscar por ID");
            System.out.println("2. Buscar por Nombre");
            System.out.println("3. Buscar por Categoría");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1 -> buscarPorId(funcionesBasicas, scanner);
                case 2 -> buscarPorNombre(funcionesBasicas, scanner);
                case 3 -> buscarPorCategoria(funcionesBasicas, scanner);
                case 4 -> System.out.println("Volviendo al Menú Principal...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private void buscarPorId(FuncionesBasicas funcionesBasicas, Scanner scanner) {
        System.out.print("Ingrese el ID del producto a buscar: ");
        String id = scanner.nextLine();
        Productos producto = funcionesBasicas.buscarProductoPorId(id);
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto);
        } else {
            System.out.println("No se encontró ningún producto con ID: " + id);
        }
    }

    private void buscarPorNombre(FuncionesBasicas funcionesBasicas, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombre = scanner.nextLine();
        List<Productos> productos = funcionesBasicas.buscarProductosPorNombre(nombre);
        if (!productos.isEmpty()) {
            System.out.println("Productos encontrados:");
            for (Productos producto : productos) {
                System.out.println(producto);
            }
        } else {
            System.out.println("No se encontraron productos con el nombre: " + nombre);
        }
    }

    private void buscarPorCategoria(FuncionesBasicas funcionesBasicas, Scanner scanner) {
        System.out.print("Ingrese la categoría del producto a buscar: ");
        String categoria = scanner.nextLine();
        List<Productos> productos = funcionesBasicas.buscarProductosPorCategoria(categoria);
        if (!productos.isEmpty()) {
            System.out.println("Productos encontrados en la categoría " + categoria + ":");
            for (Productos producto : productos) {
                System.out.println(producto);
            }
        } else {
            System.out.println("No se encontraron productos en la categoría: " + categoria);
        }
    }
}
