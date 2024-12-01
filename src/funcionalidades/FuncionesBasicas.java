package funcionalidades;
import inventario.Productos;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class FuncionesBasicas {
    private List<Productos> listaProductos;

    // Constructor
    public FuncionesBasicas() {
        this.listaProductos = new ArrayList<>();
    }

    // Metodo para agregar un producto
    public void agregarProducto(Productos producto) {
        listaProductos.add(producto);
        System.out.println("    Producto agregado: " + producto);
    }

    // Metodo para mostrar todos los productos
    public void mostrarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("    El inventario está vacío.");
        } else {
            System.out.println("\n    Inventario de productos:");
            for (Productos producto : listaProductos) {
                System.out.println(producto);
            }
        }
    }

    // Buscar producto por ID
    public Productos buscarProductoPorId(String idProducto) {
        for (Productos producto : listaProductos) {
            if (producto.getIdProducto().equalsIgnoreCase(idProducto)) {
                return producto;
            }
        }
        return null; // No se encontró el producto
    }

    // Buscar productos por nombre
    public List<Productos> buscarProductosPorNombre(String nombreProducto) {
        List<Productos> productosPorNombre = new ArrayList<>();
        for (Productos producto : listaProductos) {
            if (producto.getNombreProducto().equalsIgnoreCase(nombreProducto)) {
                productosPorNombre.add(producto);
            }
        }
        return productosPorNombre;
    }

    // Buscar productos por categoría
    public List<Productos> buscarProductosPorCategoria(String categoria) {
        List<Productos> productosPorCategoria = new ArrayList<>();
        for (Productos producto : listaProductos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                productosPorCategoria.add(producto);
            }
        }
        return productosPorCategoria;
    }


    // Metodo para actualizar un producto
    public void actualizarProducto(String idProducto, String nuevoNombre, String nuevaCategoria, double nuevoPrecio, int nuevaCantidad) {
        Productos producto = buscarProductoPorId(idProducto);
        if (producto != null) {
            producto.setNombreProducto(nuevoNombre);
            producto.setCategoria(nuevaCategoria);
            producto.setPrecio(nuevoPrecio);
            producto.setCantidadDisponible(nuevaCantidad);
            System.out.println("    Producto actualizado: " + producto);
        }
    }

    // Metodo para eliminar un producto
    public void eliminarProducto(String idProducto) {
        Productos producto = buscarProductoPorId(idProducto);
        if (producto != null) {
            listaProductos.remove(producto);
            System.out.println("    Producto eliminado: " + producto);
        }
    }

    // Cargar productos desde un archivo
    public void cargarDesdeArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println("    El archivo no existe. Se creará uno nuevo al guardar productos.");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    String id = datos[0];
                    String nombre = datos[1];
                    String categoria = datos[2];
                    double precio = Double.parseDouble(datos[3]);
                    int cantidad = Integer.parseInt(datos[4]);
                    listaProductos.add(new Productos(id, nombre, categoria, precio, cantidad));
                }
            }
            System.out.println("    Productos cargados exitosamente desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Guardar productos en un archivo
    public void guardarEnArchivo(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Productos producto : listaProductos) {
                writer.write(producto.getIdProducto() + "," +
                        producto.getNombreProducto() + "," +
                        producto.getCategoria() + "," +
                        producto.getPrecio() + "," +
                        producto.getCantidadDisponible());
                writer.newLine();
            }
            System.out.println("    Productos guardados exitosamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public List<Productos> getListaProductos() {
        return listaProductos;
    }
}
