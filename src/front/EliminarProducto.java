package front;
import funcionalidades.FuncionesBasicas;
import java.util.Scanner;

public class EliminarProducto {
    public void ejecutar(FuncionesBasicas funcionesBasicas, Scanner scanner) {
        System.out.print("Ingrese ID del producto a eliminar: ");
        String idEliminar = scanner.nextLine();
        funcionesBasicas.eliminarProducto(idEliminar);
    }
}