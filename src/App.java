import java.util.Scanner;

import funciones.ArrayUtils;


public class App {
    
    static Scanner sc = new Scanner(System.in);
    static final int NUM_ALUMNOS = 10;
    static String[] nombres = new String[NUM_ALUMNOS];
    static double[] notas = new double[NUM_ALUMNOS];
    static boolean datosIntroducidos = false;

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");
            System.out.println();

            switch (opcion) {
                case 1:
                    introducirDatos();
                    break;
                case 2:
                    mostrarDatos();
                    break;
                case 3:
                    calcularMedia();
                    break;
                case 4:
                    mostrarMaximoMinimo();
                    break;
                case 5:
                    contarAprobadosSuspensos();
                    break;
                case 6:
                    buscarAlumno();
                    break;
                case 7:
                    modificarNota();
                    break;
                case 8:
                    ordenarPorNota();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }

            System.out.println();
        } while (opcion != 0);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     GESTOR DE NOTAS DE CLASE           ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  1. Introducir alumnos y notas         ║");
        System.out.println("║  2. Mostrar todos los datos            ║");
        System.out.println("║  3. Calcular nota media                ║");
        System.out.println("║  4. Mostrar nota máxima y mínima       ║");
        System.out.println("║  5. Contar aprobados y suspensos       ║");
        System.out.println("║  6. Buscar alumno por nombre           ║");
        System.out.println("║  7. Modificar nota de un alumno        ║");
        System.out.println("║  8. Ordenar por nota (menor a mayor)   ║");
        System.out.println("║  0. Salir                              ║");
        System.out.println("╚════════════════════════════════════════╝");
    }

    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.println("Error: Introduce un número entero");
            sc.next();
            System.out.print(mensaje);
        }
        return sc.nextInt();
    }

    public static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.println("Error: Introduce un número válido");
            sc.next();
            System.out.print(mensaje);
        }
        return sc.nextDouble();
    }

    public static String leerString(String mensaje) {
        System.out.print(mensaje);
        return sc.next();
    }

    public static boolean comprobarDatosIntroducidos() {
        if (!datosIntroducidos) {
            System.out.println("Error: Primero debes introducir los datos (opción 1)");
            return false;
        }
        return true;
    }

    // ==================== NIVEL BÁSICO ====================

    public static void introducirDatos() {
        // TODO: Implementar
        // - Recorrer los arrays y pedir nombre y nota de cada alumno
        // - Validar que la nota esté entre 0 y 10 usando ArrayUtils.validarNota()
        // - Al terminar, poner datosIntroducidos = true
        String[] nombres = new String[NUM_ALUMNOS];
        double[] notas = new double[NUM_ALUMNOS];
        for (int i = 0; i < NUM_ALUMNOS; i++) {
            System.out.printf("--- Alumno %d ---%n", i + 1);
            nombres[i] = System.console().readLine("Nombre: ");
            notas[i] = Double.parseDouble(System.console().readLine("Nota: "));
            if (!ArrayUtils.validarNota(notas[i])) {
                System.out.println("Error: Nota no válida");
                datosIntroducidos = false;
                return;
            }
        }
        System.out.println("Datos introducidos correctamente");
        datosIntroducidos = true;
    }

    public static void mostrarDatos() {
        if (!comprobarDatosIntroducidos())
            return;

        // TODO: Implementar
        // - Usar ArrayUtils.mostrarDatos() para mostrar nombres y notas
        ArrayUtils.mostrarDatos(nombres, notas);
        
    }

    public static void calcularMedia() {
        if (!comprobarDatosIntroducidos())
            return;

        // TODO: Implementar
        // - Usar ArrayUtils.calcularMedia() para obtener la media
        // - Mostrar el resultado con 2 decimales
        double media = ArrayUtils.calcularMedia(notas);
        System.out.printf("La nota media de la clase es: %.2f%n", media);
    }

    // ==================== NIVEL INTERMEDIO ====================

    public static void mostrarMaximoMinimo() {
        if (!comprobarDatosIntroducidos())
            return;

        // TODO: Implementar
        // - Usar ArrayUtils.buscarMaximo() y ArrayUtils.buscarMinimo()
        // - Usar ArrayUtils.buscarPosicionNota() para encontrar la posición
        // - Mostrar el nombre del alumno con la nota máxima y mínima
    }

    public static void contarAprobadosSuspensos() {
        if (!comprobarDatosIntroducidos())
            return;

        // TODO: Implementar
        // - Usar ArrayUtils.contarAprobados() para contar aprobados
        // - Calcular suspensos restando al total
        // - Calcular y mostrar el porcentaje de aprobados
    }

    // ==================== NIVEL AVANZADO ====================

    public static void buscarAlumno() {
        if (!comprobarDatosIntroducidos())
            return;

        // TODO: Implementar
        // - Pedir al usuario el nombre a buscar
        // - Usar ArrayUtils.buscarPosicionNombre() para buscar
        // - Si devuelve -1, el alumno no existe
        // - Si existe, mostrar su nombre y nota
    }

    public static void modificarNota() {
        if (!comprobarDatosIntroducidos())
            return;

        // TODO: Implementar
        // - Pedir el nombre del alumno
        // - Buscar si existe con ArrayUtils.buscarPosicionNombre()
        // - Si no existe, mostrar error
        // - Si existe, pedir la nueva nota y validarla
        // - Mostrar: "Nota de [nombre] modificada: X.XX -> Y.YY"
    }

    public static void ordenarPorNota() {
        if (!comprobarDatosIntroducidos())
            return;

        // TODO: Implementar
        // - Usar ArrayUtils.ordenarBurbuja() para ordenar ambos arrays
        // - IMPORTANTE: Al intercambiar notas, también intercambiar nombres
        // - Mostrar los datos ordenados
    }
}
