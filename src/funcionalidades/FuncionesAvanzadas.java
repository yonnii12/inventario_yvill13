package funcionalidades;
import inventario.Productos;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuncionesAvanzadas {
    private List<Productos> listaProductos;

    // Constructor
    public FuncionesAvanzadas(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Productos productoMasCaro() {
        if (listaProductos.isEmpty()) {
            System.out.println("    El inventario está vacío.");
            return null;
        }

        Productos masCaro = listaProductos.get(0);
        for (Productos producto : listaProductos) {
            if (producto.getPrecio() > masCaro.getPrecio()) {
                masCaro = producto;
            }
        }
        System.out.println("    El producto más caro es: " + masCaro);
        return masCaro;
    }

    public void cantidadProductosPorCategoria() {
        if (listaProductos.isEmpty()) {
            System.out.println("    El inventario está vacío.");
            return;
        }

        Map<String, Integer> contador = new HashMap<>();
        for (Productos producto : listaProductos) {
            contador.put(producto.getCategoria(), contador.getOrDefault(producto.getCategoria(), 0) + 1);
        }

        System.out.println("Cantidad de productos por categoría:");
        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void generarReporte(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write("Reporte de Inventario\n");
            writer.write("======================\n");
            double valorTotal = 0;

            for (Productos producto : listaProductos) {
                writer.write(producto.toString() + "\n");
                valorTotal += producto.getPrecio() * producto.getCantidadDisponible();
            }

            writer.write("======================\n");
            writer.write("Valor total del inventario: $" + valorTotal + "\n");
            System.out.println("Reporte generado exitosamente en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al generar el reporte: " + e.getMessage());
        }
    }
}
