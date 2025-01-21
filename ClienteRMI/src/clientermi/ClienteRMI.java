package clientermi;

import interfaz.Inventario;
import modelo.Libro;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteRMI {

    public static void main(String[] args) {
        try {
            // Nos conectamos a localhost por el 1099 (Puerto por defecto)
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            
            // Buscamos "InventarioService" que esta registrado en el servidor remoto
            Inventario inventario = (Inventario) registro.lookup("InventarioService");
            
            Scanner scanner = new Scanner(System.in);
            int opcion;
            
            do {
                System.out.println("Menu de Gestion de Inventario");
                System.out.println("1. Listar todos los libros");
                System.out.println("2. Agregar un libro");
                System.out.println("3. Actualizar la cantidad de un libro");
                System.out.println("4. Eliminar un libro");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Listado de libros:");
                        for (Libro libro : inventario.listarLibros()) {
                            System.out.println(libro);
                        }
                        break;
                        
                    case 2:
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Titulo: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();
                        System.out.print("Precio: ");
                        double precio = scanner.nextDouble();
                        System.out.print("Cantidad: ");
                        int cantidad = scanner.nextInt();

                        if (inventario.agregarLibro(id, titulo, autor, precio, cantidad)) {
                            System.out.println("Libro agregado exitosamente :D");
                        } else {
                            System.out.println("Error: Ya existe un libro con este ID :(");
                        }
                        break;
                        
                    case 3:
                        System.out.print("ID del libro: ");
                        int idActualizar = scanner.nextInt();
                        System.out.print("Nueva cantidad: ");
                        int nuevaCantidad = scanner.nextInt();

                        if (inventario.actualizarCantidad(idActualizar, nuevaCantidad)) {
                            System.out.println("Cantidad actualizada exitosamente :D");
                        } else {
                            System.out.println("Error: Libro no encontrado :(");
                        }
                        break;
                        
                    case 4:
                        System.out.print("ID del libro a eliminar: ");
                        int idEliminar = scanner.nextInt();

                        if (inventario.eliminarLibro(idEliminar)) {
                            System.out.println("Libro eliminado exitosamente :D");
                        } else {
                            System.out.println("Error: Libro no encontrado :(");
                        }
                        break;
                        
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                        
                    default:
                        System.out.println("Opcion invalida.");
                        break;
                        
                }
                
            } while (opcion != 5);
            
        } catch (Exception e) {
            System.err.println("Error en el cliente :(");
            System.err.println(e.getMessage());
        }

    }
    
}
