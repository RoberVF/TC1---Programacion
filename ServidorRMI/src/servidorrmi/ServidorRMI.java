package servidorrmi;

import interfaz.Inventario;
import servidor.InventarioImplements;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {

    public static void main(String[] args) {
        try {
            Inventario inventario = new InventarioImplements();
            
            // Nos conectamos a localhost por el puerto por defecto 1099
            Registry registro = LocateRegistry.createRegistry(1099);
            
            // Lanzamos el objeto InventarioService para que lo tenga disponible el cliente en remoto
            registro.rebind("InventarioService", inventario);
            
            System.out.println("Servidor RMI inicializado correctamente :D");
            
        } catch(Exception e){
            System.err.println("Error en el servidor :(");
            System.err.println(e.getMessage());
        }
    }
    
}
