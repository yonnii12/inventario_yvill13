package front;
import funcionalidades.FuncionesAvanzadas;
import funcionalidades.FuncionesBasicas;

public class ProductoMasCaro {
    public void ejecutar(FuncionesBasicas funcionesBasicas) {
        FuncionesAvanzadas funcionesAvanzadas = new FuncionesAvanzadas(funcionesBasicas.getListaProductos());
        funcionesAvanzadas.productoMasCaro();
    }
}
