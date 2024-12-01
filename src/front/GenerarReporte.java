package front;
import funcionalidades.FuncionesAvanzadas;
import funcionalidades.FuncionesBasicas;
import java.util.Scanner;

public class GenerarReporte {
    public void ejecutar(FuncionesBasicas funcionesBasicas, Scanner scanner) {
        FuncionesAvanzadas funcionesAvanzadas = new FuncionesAvanzadas(funcionesBasicas.getListaProductos());
        String rutaArchivo = System.getProperty("java.io.tmpdir") + "reporte_inventario.txt";
        funcionesAvanzadas.generarReporte(rutaArchivo);
    }
}