package front;
import funcionalidades.FuncionesAvanzadas;
import funcionalidades.FuncionesBasicas;

public class CantidadProductosPorCategoria {
    public void ejecutar(FuncionesBasicas funcionesBasicas) {
        FuncionesAvanzadas funcionesAvanzadas = new FuncionesAvanzadas(funcionesBasicas.getListaProductos());
        funcionesAvanzadas.cantidadProductosPorCategoria();
    }
}