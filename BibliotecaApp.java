import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    // prestamo = [idPrestamo, nombreUsuario, tituloLibro, diasPrestamo, multaPorDia]
    static ArrayList<ArrayList<Object>> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> registrarPrestamo();
                case 2 -> mostrarPrestamos();
                case 3 -> buscarPrestamoPorId();
                case 4 -> actualizarPrestamo();
                case 5 -> eliminarPrestamo();
                case 6 -> calcularTotalMultas();
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
            System.out.println();
        } while (opcion != 7);

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("=== Biblioteca: Gestión de Préstamos ===");
        System.out.println("1. Registrar nuevo préstamo");
        System.out.println("2. Mostrar todos los préstamos");
        System.out.println("3. Buscar préstamo por ID");
        System.out.println("4. Actualizar un préstamo");
        System.out.println("5. Eliminar un préstamo");
        System.out.println("6. Calcular total de multas");
        System.out.println("7. Salir");
    }

    // ====== CRUD (por implementar) ======
    static void registrarPrestamo() {   
    ArrayList<Object> prestamo = new ArrayList<>();
        
    System.out.println("ID:");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.println("Nombre:");
    String nombre = sc.nextLine();
    System.out.println("Libros:");
    int libros = sc.nextInt();
    sc.nextLine();
    prestamo.add(id);
    prestamo.add(nombre);
    prestamo.add(libros);
    prestamos.add(prestamo); }
    static void mostrarPrestamos() {
 if (prestamos.isEmpty()) {
        System.out.println("No hay préstamos registradis");
        return;
    }
    for (int i = 0; i < prestamos.size(); i++) {
        ArrayList<Object> prestamo = prestamos.get(i);
        System.out.println("Préstamo #" + (i + 1));
        for (int j = 0; j < prestamo.size(); j++) {
            System.out.println("  Dato " + j + ": " + prestamo.get(j));
        } 
    }     
    }
    static void buscarPrestamoPorId() {
    System.out.println("Ingrese ID:");
    int idBuscado = sc.nextInt();
    sc.nextLine();
    boolean encontrado = false;
    for (ArrayList<Object> prestamo : prestamos) {
        int id = (int) prestamo.get(0);
        if (id == idBuscado) {
System.out.println("ID: " + prestamo.get(0));
System.out.println("Usuario: " + prestamo.get(1));
System.out.println("Libros: " + prestamo.get(2));
System.out.println("------------------");
            encontrado = true;
            break;
        }
    }
    if (!encontrado) {
        System.out.println("No existe ese préstamo.");
    }  
    }
    static void actualizarPrestamo() {


        
    }
    static void eliminarPrestamo() {


        
    }

    // ====== Cálculo (por implementar) ======
    static void calcularTotalMultas() { /* TODO */ }

    // ====== Utilidades mínimas ======
    static int leerEntero(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Ingrese un entero válido.");
            }
        }
    }

    static String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}
