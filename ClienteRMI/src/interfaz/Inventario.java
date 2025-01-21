package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Libro;

public interface Inventario extends Remote {
    List<Libro> listarLibros() throws RemoteException;
    boolean agregarLibro(int id, String titulo, String autor, double precio, int cantidad) throws RemoteException;
    boolean actualizarCantidad(int id, int nuevaCantidad) throws RemoteException;
    boolean eliminarLibro(int id) throws RemoteException;
}
