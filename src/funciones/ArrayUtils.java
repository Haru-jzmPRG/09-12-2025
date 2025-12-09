package funciones;
public class ArrayUtils {

    // ==================== NIVEL BÁSICO ====================

    public static boolean validarNota(double nota) {
        // TODO: Implementar
        // - Devolver true si la nota está entre 0 y 10
        // - Devolver false en caso contrario

        if (nota >= 0 && nota <= 10) {
            return true;
        }
        return false;
    }

    public static void mostrarDatos(String[] nombres, double[] notas) {
        // TODO: Implementar
        // - Recorrer los arrays y mostrar cada alumno
        // - Formato: "1. Juan: 7.50"
        System.out.printf("=== LISTADO DE LA CALSE ===%n");
        for (int i = 0; i < nombres.length; i++) {
            System.out.printf("%d. %s: %.2f%n", i + 1, nombres[i], notas[i]);
        }
        
    }

    public static double calcularMedia(double[] notas) {
        // TODO: Implementar
        // - Sumar todas las notas
        // - Dividir entre el número de elementos
        // - Devolver la media
        int suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        return (double) suma / notas.length;
    }

    // ==================== NIVEL INTERMEDIO ====================

    public static double buscarMaximo(double[] notas) {
        // TODO: Implementar
        // - Recorrer el array buscando el valor máximo
        // - Devolver el valor máximo encontrado
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > max) {
                max = notas[i];
            }
        }
        return max;
    }

    public static double buscarMinimo(double[] notas) {
        // TODO: Implementar
        // - Recorrer el array buscando el valor mínimo
        // - Devolver el valor mínimo encontrado
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < min) {
                min = notas[i];
            }
        }
        return min;
    }

    public static int buscarPosicionNota(double[] notas, double valor) {
        // TODO: Implementar
        // - Recorrer el array buscando el valor
        // - Si lo encuentra, devolver la posición (índice)
        // - Si no lo encuentra, devolver -1
        for (int i = 0; i < notas.length; i++){
            if (notas[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public static int contarAprobados(double[] notas) {
        // TODO: Implementar
        // - Contar cuántas notas son >= 5
        // - Devolver el contador
        int contador = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= 5){
                contador++;
            }
        }
        return contador;
        
    }

    // ==================== NIVEL AVANZADO ====================

    public static int buscarPosicionNombre(String[] nombres, String nombre) {
        // TODO: Implementar
        // - Recorrer el array buscando el nombre (ignorar mayúsculas/minúsculas)
        // - Usar equalsIgnoreCase() para comparar
        // - Si lo encuentra, devolver la posición (índice)
        // - Si no lo encuentra, devolver -1
        return -1;
    }

    public static void ordenarBurbuja(String[] nombres, double[] notas) {
        // TODO: Implementar
        // - Ordenar por nota de menor a mayor usando burbuja
        // - IMPORTANTE: Al intercambiar notas, también intercambiar nombres
        // - Así se mantiene la correspondencia entre arrays
    }
}
