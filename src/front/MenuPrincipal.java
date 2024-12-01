package front;
import funcionalidades.FuncionesAvanzadas;
import funcionalidades.FuncionesBasicas;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        FuncionesBasicas funcionesBasicas = new FuncionesBasicas();
        Scanner scanner = new Scanner(System.in);

        // Ruta del archivo para cargar y guardar productos
        String rutaArchivo = "D:/ProgramacionBasica/inventario_java_yvill13/productos.txt";

        // Cargar productos desde el archivo al iniciar
        funcionesBasicas.cargarDesdeArchivo(rutaArchivo);

        int opcion;

        do {
            System.out.println("\nMenú de Inventario");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Productos en pantalla");
            System.out.println("3. Buscar Productos");
            System.out.println("4. Actualizar Producto");
            System.out.println("5. Eliminar Producto");
            System.out.println("6. Calcular el Producto Más Caro");
            System.out.println("7. Cantidad de Productos por Categoría");
            System.out.println("8. Generar Reporte");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1 -> {
                    new AgregarProducto().ejecutar(funcionesBasicas, scanner);
                    funcionesBasicas.guardarEnArchivo(rutaArchivo);
                    System.out.println("Ingrese Enter para  volver al menu anterior...");
                    scanner.nextLine();
                }
                case 2 -> {
                    new MostrarProductos().ejecutar(funcionesBasicas);
                    System.out.println("Ingrese Enter para  volver al menu anterior...");
                    scanner.nextLine();
                }
                case 3 -> new SubMenuBuscar().ejecutar(funcionesBasicas, scanner);
                case 4 -> {
                    new ActualizarProducto().ejecutar(funcionesBasicas, scanner);
                    funcionesBasicas.guardarEnArchivo(rutaArchivo);
                    System.out.println("Ingrese Enter para  volver al menu anterior...");
                    scanner.nextLine();
                }
                case 5 -> {
                    new EliminarProducto().ejecutar(funcionesBasicas, scanner);
                    funcionesBasicas.guardarEnArchivo(rutaArchivo);
                    System.out.println("Ingrese Enter para  volver al menu anterior...");
                    scanner.nextLine();
                }
                case 6 -> {
                    new ProductoMasCaro().ejecutar(funcionesBasicas);
                    System.out.println("Ingrese Enter para  volver al menu anterior...");
                    scanner.nextLine();
                }
                case 7 -> {
                    new CantidadProductosPorCategoria().ejecutar(funcionesBasicas);
                    System.out.println("Ingrese Enter para  volver al menu anterior...");
                    scanner.nextLine();
                }
                case 8 -> {
                    new GenerarReporte().ejecutar(funcionesBasicas, scanner);
                    System.out.println("Ingrese Enter para  volver al menu anterior...");
                    scanner.nextLine();
                }
                case 9 -> System.out.println("Saliendo del programa. ¡Hasta pronto!");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}
