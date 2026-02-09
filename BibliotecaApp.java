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
    System.out.println("ID del prestamo:");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.println("Nombre del usuario:");
    String nombre = sc.nextLine();
    System.out.println("Titulo del libro:");
    String libro = sc.nextLine();
    System.out.println("Dias de prestamo:");
    int dias = sc.nextInt();
    sc.nextLine();
    System.out.println("Multa por dia:");
    float multa = sc.nextDouble();
    sc.nextLine();
    prestamo.add(id);
    prestamo.add(nombre);
    prestamo.add(libro);
    prestamo.add(dias);
    prestamo.add(multa);
    prestamos.add(prestamo);
    System.out.println("Prestamo registrado correctament"); }
    static void mostrarPrestamos() {
    if (prestamos.isEmpty()) {
        System.out.println("No hay prestamos registrados");
        return;
    }

    for (ArrayList<Object> prestamo : prestamos) {
        System.out.println("ID: " + prestamo.get(0));
        System.out.println("Usuario: " + prestamo.get(1));
        System.out.println("Libro: " + prestamo.get(2));
        System.out.println("Dias de prestamo: " + prestamo.get(3));
        System.out.println("Multa por dia: " + prestamo.get(4));
        System.out.println("----------------------..");
    }
    }
  static void buscarPrestamoPorId() {
    System.out.println("Ingrese ID a buscar:");
    int idBuscado = sc.nextInt();
    sc.nextLine();

    boolean encontrado = false;

    for (ArrayList<Object> prestamo : prestamos) {
        int id = (int) prestamo.get(0);
        if (id == idBuscado) {
            System.out.println("ID: " + prestamo.get(0));
            System.out.println("Usuario: " + prestamo.get(1));
            System.out.println("Libro: " + prestamo.get(2));
            System.out.println("Dias de prestamo: " + prestamo.get(3));
            System.out.println("Multa/dia: " + prestamo.get(4));
            System.out.println("----------------------");
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("No existe ese prrstamo.");
    }
}
  static void actualizarPrestamo() {
    System.out.println("Ingrese ID del prrstamo a actualizar:");
    int idBuscado = sc.nextInt();
    sc.nextLine();

    boolean encontrado = false;

    for (ArrayList<Object> prestamo : prestamos) {
        int id = (int) prestamo.get(0);
        if (id == idBuscado) {
    
            System.out.println("Datos actuales:");
            System.out.println("1. Usuario: " + prestamo.get(1));
            System.out.println("2. Libro: " + prestamo.get(2));
            System.out.println("3. Dias: " + prestamo.get(3));
            System.out.println("4. Multapor día: " + prestamo.get(4));
            
    
            System.out.println("Ingrese nuevo nombre de usuario:");
            String nuevoNombre = sc.nextLine();
            System.out.println("Ingrese nuevo título del libro:");
            String nuevoLibro = sc.nextLine();
            System.out.println("Ingrese nuevos días de préstamo:");
            int nuevosDias = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese nueva multa por día:");
            float nuevaMulta = sc.nextDouble();
            sc.nextLine();
            
            prestamo.set(1, nuevoNombre);
            prestamo.set(2, nuevoLibro);
            prestamo.set(3, nuevosDias);
            prestamo.set(4, nuevaMulta);



            
            System.out.println("Préstamo actualizado correctamente");
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("No existe ese prestamo");
    }
}
 static void eliminarPrestamo() {
    System.out.println("Ingrese ID del prestamo que quiere eliminar:");
    int idBuscado = sc.nextInt();
    sc.nextLine();

    boolean encontrado = false;

   for (int i = 0; i < prestamos.size(); i++) {
    int id = (int) prestamos.get(i).get(0);
    if (id == idBuscado) {
        prestamos.remove(i);
        System.out.println("Prestamo eliminado correctamente");
        encontrado = true;
        break;
    }
}

    if (!encontrado) {
        System.out.println("No existe ese prestamo.");
    }
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
