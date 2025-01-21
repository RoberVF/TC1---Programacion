package servidor;

import interfaz.Inventario;
import modelo.Libro;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class InventarioImplements extends UnicastRemoteObject implements Inventario {
    private final List<Libro> inventario;
    
    public InventarioImplements() throws RemoteException {
        super();
        this.inventario = new ArrayList<>();
    }
    
    @Override
    public List<Libro> listarLibros() throws RemoteException {
        return inventario;
    }

    @Override
    public boolean agregarLibro(int id, String titulo, String autor, double precio, int cantidad) throws RemoteException {
        for (Libro libro : inventario) {
            if (libro.getId() == id) {
                // Compruebo que no exista un libro con ese id
                return false;
            }
        }
        
        // Si no existe libro con ese id, lo creo
        inventario.add(new Libro(id, titulo, autor, precio, cantidad));
        return true;
    }

    @Override
    public boolean actualizarCantidad(int id, int nuevaCantidad) throws RemoteException {
        for (Libro libro : inventario) {
            if (libro.getId() == id) {
                // Si encuentra un libro con ese id, le actualizamos la cantidad
                libro.setCantidad(nuevaCantidad);
                return true;
            }
        }
        
        // Si no hay libros con ese id, retornamos false
        return false;
    }

    @Override
    public boolean eliminarLibro(int id) throws RemoteException {
        // Esta forma de eliminar es mas rapida que haciendo un bucle :)
        return inventario.removeIf(libro -> libro.getId() == id);
    }
}
