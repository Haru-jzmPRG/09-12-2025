import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {

    @Nested
    @DisplayName("Tests para validarNota()")
    class ValidarNotaTests {

        @Test
        @DisplayName("Nota 5 debe ser válida")
        void notaCincoDebeSerValida() {
            assertTrue(ArrayUtils.validarNota(5));
        }

        @Test
        @DisplayName("Nota 0 (límite inferior) debe ser válida")
        void notaCeroDebeSerValida() {
            assertTrue(ArrayUtils.validarNota(0));
        }

        @Test
        @DisplayName("Nota 10 (límite superior) debe ser válida")
        void notaDiezDebeSerValida() {
            assertTrue(ArrayUtils.validarNota(10));
        }

        @Test
        @DisplayName("Nota 7.5 (decimal) debe ser válida")
        void notaDecimalDebeSerValida() {
            assertTrue(ArrayUtils.validarNota(7.5));
        }

        @Test
        @DisplayName("Nota negativa (-1) no debe ser válida")
        void notaNegativaNoDebeSerValida() {
            assertFalse(ArrayUtils.validarNota(-1));
        }

        @Test
        @DisplayName("Nota mayor que 10 (11) no debe ser válida")
        void notaMayorQueDiezNoDebeSerValida() {
            assertFalse(ArrayUtils.validarNota(11));
        }

        @Test
        @DisplayName("Nota -0.01 (justo por debajo de 0) no debe ser válida")
        void notaJustoPorDebajoDeZeroNoDebeSerValida() {
            assertFalse(ArrayUtils.validarNota(-0.01));
        }

        @Test
        @DisplayName("Nota 10.01 (justo por encima de 10) no debe ser válida")
        void notaJustoPorEncimaDeDiezNoDebeSerValida() {
            assertFalse(ArrayUtils.validarNota(10.01));
        }

        @Test
        @DisplayName("Nota muy grande (100) no debe ser válida")
        void notaMuyGrandeNoDebeSerValida() {
            assertFalse(ArrayUtils.validarNota(100));
        }

        @Test
        @DisplayName("Nota muy negativa (-100) no debe ser válida")
        void notaMuyNegativaNoDebeSerValida() {
            assertFalse(ArrayUtils.validarNota(-100));
        }
    }

    @Nested
    @DisplayName("Tests para calcularMedia()")
    class CalcularMediaTests {

        @Test
        @DisplayName("Media de [5, 5, 5, 5] debe ser 5")
        void mediaDeValoresIgualesDebeSer5() {
            double[] notas = {5, 5, 5, 5};
            assertEquals(5.0, ArrayUtils.calcularMedia(notas), 0.001);
        }

        @Test
        @DisplayName("Media de [0, 10] debe ser 5")
        void mediaDeCeroYDiezDebeSer5() {
            double[] notas = {0, 10};
            assertEquals(5.0, ArrayUtils.calcularMedia(notas), 0.001);
        }

        @Test
        @DisplayName("Media de [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] debe ser 5.5")
        void mediaDeUnoADiezDebeSer5punto5() {
            double[] notas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            assertEquals(5.5, ArrayUtils.calcularMedia(notas), 0.001);
        }

        @Test
        @DisplayName("Media de un solo elemento [7] debe ser 7")
        void mediaDeUnSoloElemento() {
            double[] notas = {7};
            assertEquals(7.0, ArrayUtils.calcularMedia(notas), 0.001);
        }

        @Test
        @DisplayName("Media de [0, 0, 0, 0] debe ser 0")
        void mediaDeCerosDebeSerCero() {
            double[] notas = {0, 0, 0, 0};
            assertEquals(0.0, ArrayUtils.calcularMedia(notas), 0.001);
        }

        @Test
        @DisplayName("Media de [10, 10, 10, 10] debe ser 10")
        void mediaDeDiecesDebeSerDiez() {
            double[] notas = {10, 10, 10, 10};
            assertEquals(10.0, ArrayUtils.calcularMedia(notas), 0.001);
        }

        @Test
        @DisplayName("Media con decimales [5.5, 6.5, 7.5, 8.5] debe ser 7")
        void mediaConDecimales() {
            double[] notas = {5.5, 6.5, 7.5, 8.5};
            assertEquals(7.0, ArrayUtils.calcularMedia(notas), 0.001);
        }
    }

    @Nested
    @DisplayName("Tests para buscarMaximo()")
    class BuscarMaximoTests {

        @Test
        @DisplayName("Máximo de [3, 7, 2, 9, 5] debe ser 9")
        void maximoEnElMedio() {
            double[] notas = {3, 7, 2, 9, 5};
            assertEquals(9.0, ArrayUtils.buscarMaximo(notas), 0.001);
        }

        @Test
        @DisplayName("Máximo de [10, 5, 3, 2, 1] debe ser 10 (al principio)")
        void maximoAlPrincipio() {
            double[] notas = {10, 5, 3, 2, 1};
            assertEquals(10.0, ArrayUtils.buscarMaximo(notas), 0.001);
        }

        @Test
        @DisplayName("Máximo de [1, 2, 3, 4, 10] debe ser 10 (al final)")
        void maximoAlFinal() {
            double[] notas = {1, 2, 3, 4, 10};
            assertEquals(10.0, ArrayUtils.buscarMaximo(notas), 0.001);
        }

        @Test
        @DisplayName("Máximo de [5, 5, 5, 5] debe ser 5 (todos iguales)")
        void maximoTodosIguales() {
            double[] notas = {5, 5, 5, 5};
            assertEquals(5.0, ArrayUtils.buscarMaximo(notas), 0.001);
        }

        @Test
        @DisplayName("Máximo de un solo elemento [7] debe ser 7")
        void maximoUnSoloElemento() {
            double[] notas = {7};
            assertEquals(7.0, ArrayUtils.buscarMaximo(notas), 0.001);
        }

        @Test
        @DisplayName("Máximo de [0, 0, 0, 0.5] debe ser 0.5")
        void maximoConDecimalesPequenios() {
            double[] notas = {0, 0, 0, 0.5};
            assertEquals(0.5, ArrayUtils.buscarMaximo(notas), 0.001);
        }
    }

    @Nested
    @DisplayName("Tests para buscarMinimo()")
    class BuscarMinimoTests {

        @Test
        @DisplayName("Mínimo de [3, 7, 2, 9, 5] debe ser 2")
        void minimoEnElMedio() {
            double[] notas = {3, 7, 2, 9, 5};
            assertEquals(2.0, ArrayUtils.buscarMinimo(notas), 0.001);
        }

        @Test
        @DisplayName("Mínimo de [0, 5, 7, 8, 9] debe ser 0 (al principio)")
        void minimoAlPrincipio() {
            double[] notas = {0, 5, 7, 8, 9};
            assertEquals(0.0, ArrayUtils.buscarMinimo(notas), 0.001);
        }

        @Test
        @DisplayName("Mínimo de [10, 8, 6, 4, 1] debe ser 1 (al final)")
        void minimoAlFinal() {
            double[] notas = {10, 8, 6, 4, 1};
            assertEquals(1.0, ArrayUtils.buscarMinimo(notas), 0.001);
        }

        @Test
        @DisplayName("Mínimo de [5, 5, 5, 5] debe ser 5 (todos iguales)")
        void minimoTodosIguales() {
            double[] notas = {5, 5, 5, 5};
            assertEquals(5.0, ArrayUtils.buscarMinimo(notas), 0.001);
        }

        @Test
        @DisplayName("Mínimo de un solo elemento [7] debe ser 7")
        void minimoUnSoloElemento() {
            double[] notas = {7};
            assertEquals(7.0, ArrayUtils.buscarMinimo(notas), 0.001);
        }

        @Test
        @DisplayName("Mínimo de [10, 10, 10, 9.9] debe ser 9.9")
        void minimoConDecimales() {
            double[] notas = {10, 10, 10, 9.9};
            assertEquals(9.9, ArrayUtils.buscarMinimo(notas), 0.001);
        }
    }

    @Nested
    @DisplayName("Tests para buscarPosicionNota()")
    class BuscarPosicionNotaTests {

        @Test
        @DisplayName("Buscar 7 en [3, 7, 2, 9, 5] debe devolver 1")
        void buscarNotaExistenteEnMedio() {
            double[] notas = {3, 7, 2, 9, 5};
            assertEquals(1, ArrayUtils.buscarPosicionNota(notas, 7));
        }

        @Test
        @DisplayName("Buscar 3 en [3, 7, 2, 9, 5] debe devolver 0 (primera posición)")
        void buscarNotaEnPrimeraPosicion() {
            double[] notas = {3, 7, 2, 9, 5};
            assertEquals(0, ArrayUtils.buscarPosicionNota(notas, 3));
        }

        @Test
        @DisplayName("Buscar 5 en [3, 7, 2, 9, 5] debe devolver 4 (última posición)")
        void buscarNotaEnUltimaPosicion() {
            double[] notas = {3, 7, 2, 9, 5};
            assertEquals(4, ArrayUtils.buscarPosicionNota(notas, 5));
        }

        @Test
        @DisplayName("Buscar 10 en [3, 7, 2, 9, 5] debe devolver -1 (no existe)")
        void buscarNotaNoExistente() {
            double[] notas = {3, 7, 2, 9, 5};
            assertEquals(-1, ArrayUtils.buscarPosicionNota(notas, 10));
        }

        @Test
        @DisplayName("Buscar 5 en [5, 5, 5, 5] debe devolver 0 (primera ocurrencia)")
        void buscarNotaConMultiplesOcurrencias() {
            double[] notas = {5, 5, 5, 5};
            assertEquals(0, ArrayUtils.buscarPosicionNota(notas, 5));
        }

        @Test
        @DisplayName("Buscar 7.5 en [3.5, 7.5, 2.5] debe devolver 1 (decimal)")
        void buscarNotaDecimal() {
            double[] notas = {3.5, 7.5, 2.5};
            assertEquals(1, ArrayUtils.buscarPosicionNota(notas, 7.5));
        }

        @Test
        @DisplayName("Buscar en array de un elemento existente")
        void buscarEnArrayUnElementoExiste() {
            double[] notas = {5};
            assertEquals(0, ArrayUtils.buscarPosicionNota(notas, 5));
        }

        @Test
        @DisplayName("Buscar en array de un elemento no existente")
        void buscarEnArrayUnElementoNoExiste() {
            double[] notas = {5};
            assertEquals(-1, ArrayUtils.buscarPosicionNota(notas, 7));
        }
    }

    @Nested
    @DisplayName("Tests para contarAprobados()")
    class ContarAprobadosTests {

        @Test
        @DisplayName("Contar aprobados en [5, 6, 7, 8, 9, 10] debe ser 6 (todos aprobados)")
        void todosAprobados() {
            double[] notas = {5, 6, 7, 8, 9, 10};
            assertEquals(6, ArrayUtils.contarAprobados(notas));
        }

        @Test
        @DisplayName("Contar aprobados en [0, 1, 2, 3, 4] debe ser 0 (ninguno aprobado)")
        void ningunoAprobado() {
            double[] notas = {0, 1, 2, 3, 4};
            assertEquals(0, ArrayUtils.contarAprobados(notas));
        }

        @Test
        @DisplayName("Contar aprobados en [4, 5, 6, 7] debe ser 3")
        void algunosAprobados() {
            double[] notas = {4, 5, 6, 7};
            assertEquals(3, ArrayUtils.contarAprobados(notas));
        }

        @Test
        @DisplayName("Contar aprobados con nota exactamente 5 (límite)")
        void notaExactamenteCinco() {
            double[] notas = {5, 5, 5};
            assertEquals(3, ArrayUtils.contarAprobados(notas));
        }

        @Test
        @DisplayName("Contar aprobados con nota 4.99 (justo por debajo)")
        void notaJustoPorDebajoDeCinco() {
            double[] notas = {4.99, 4.99, 4.99};
            assertEquals(0, ArrayUtils.contarAprobados(notas));
        }

        @Test
        @DisplayName("Contar aprobados con nota 5.01 (justo por encima)")
        void notaJustoPorEncimaDeCinco() {
            double[] notas = {5.01, 5.01, 5.01};
            assertEquals(3, ArrayUtils.contarAprobados(notas));
        }

        @Test
        @DisplayName("Contar aprobados en array de 10 alumnos")
        void arrayDiezAlumnos() {
            double[] notas = {3, 4.5, 5, 6, 7, 8, 9, 10, 4, 5};
            assertEquals(7, ArrayUtils.contarAprobados(notas));
        }

        @Test
        @DisplayName("Contar aprobados en [0, 0, 0, 0] debe ser 0")
        void todosCeros() {
            double[] notas = {0, 0, 0, 0};
            assertEquals(0, ArrayUtils.contarAprobados(notas));
        }

        @Test
        @DisplayName("Contar aprobados en [10, 10, 10, 10] debe ser 4")
        void todosDieces() {
            double[] notas = {10, 10, 10, 10};
            assertEquals(4, ArrayUtils.contarAprobados(notas));
        }
    }

    @Nested
    @DisplayName("Tests para buscarPosicionNombre()")
    class BuscarPosicionNombreTests {

        @Test
        @DisplayName("Buscar 'Juan' en ['Ana', 'Juan', 'Pedro'] debe devolver 1")
        void buscarNombreExistente() {
            String[] nombres = {"Ana", "Juan", "Pedro"};
            assertEquals(1, ArrayUtils.buscarPosicionNombre(nombres, "Juan"));
        }

        @Test
        @DisplayName("Buscar 'Ana' en primera posición")
        void buscarNombreEnPrimeraPosicion() {
            String[] nombres = {"Ana", "Juan", "Pedro"};
            assertEquals(0, ArrayUtils.buscarPosicionNombre(nombres, "Ana"));
        }

        @Test
        @DisplayName("Buscar 'Pedro' en última posición")
        void buscarNombreEnUltimaPosicion() {
            String[] nombres = {"Ana", "Juan", "Pedro"};
            assertEquals(2, ArrayUtils.buscarPosicionNombre(nombres, "Pedro"));
        }

        @Test
        @DisplayName("Buscar 'Maria' no existente debe devolver -1")
        void buscarNombreNoExistente() {
            String[] nombres = {"Ana", "Juan", "Pedro"};
            assertEquals(-1, ArrayUtils.buscarPosicionNombre(nombres, "Maria"));
        }

        @Test
        @DisplayName("Buscar 'JUAN' (mayúsculas) debe encontrar 'Juan'")
        void buscarNombreIgnorandoMayusculas() {
            String[] nombres = {"Ana", "Juan", "Pedro"};
            assertEquals(1, ArrayUtils.buscarPosicionNombre(nombres, "JUAN"));
        }

        @Test
        @DisplayName("Buscar 'juan' (minúsculas) debe encontrar 'Juan'")
        void buscarNombreIgnorandoMinusculas() {
            String[] nombres = {"Ana", "Juan", "Pedro"};
            assertEquals(1, ArrayUtils.buscarPosicionNombre(nombres, "juan"));
        }

        @Test
        @DisplayName("Buscar 'JuAn' (mixto) debe encontrar 'Juan'")
        void buscarNombreMayusculasMinusculasMixtas() {
            String[] nombres = {"Ana", "Juan", "Pedro"};
            assertEquals(1, ArrayUtils.buscarPosicionNombre(nombres, "JuAn"));
        }

        @Test
        @DisplayName("Buscar en array de un solo nombre existente")
        void buscarEnArrayUnNombreExiste() {
            String[] nombres = {"Ana"};
            assertEquals(0, ArrayUtils.buscarPosicionNombre(nombres, "Ana"));
        }

        @Test
        @DisplayName("Buscar en array de un solo nombre no existente")
        void buscarEnArrayUnNombreNoExiste() {
            String[] nombres = {"Ana"};
            assertEquals(-1, ArrayUtils.buscarPosicionNombre(nombres, "Juan"));
        }

        @Test
        @DisplayName("Buscar con múltiples ocurrencias devuelve la primera")
        void buscarConMultiplesOcurrencias() {
            String[] nombres = {"Ana", "Juan", "Ana", "Pedro"};
            assertEquals(0, ArrayUtils.buscarPosicionNombre(nombres, "Ana"));
        }
    }

    @Nested
    @DisplayName("Tests para ordenarBurbuja()")
    class OrdenarBurbujaTests {

        @Test
        @DisplayName("Ordenar array desordenado de menor a mayor")
        void ordenarArrayDesordenado() {
            String[] nombres = {"Pedro", "Ana", "Juan"};
            double[] notas = {8, 3, 5};
            
            ArrayUtils.ordenarBurbuja(nombres, notas);
            
            assertArrayEquals(new double[]{3, 5, 8}, notas, 0.001);
            assertArrayEquals(new String[]{"Ana", "Juan", "Pedro"}, nombres);
        }

        @Test
        @DisplayName("Ordenar array ya ordenado (no cambia)")
        void ordenarArrayYaOrdenado() {
            String[] nombres = {"Ana", "Juan", "Pedro"};
            double[] notas = {3, 5, 8};
            
            ArrayUtils.ordenarBurbuja(nombres, notas);
            
            assertArrayEquals(new double[]{3, 5, 8}, notas, 0.001);
            assertArrayEquals(new String[]{"Ana", "Juan", "Pedro"}, nombres);
        }

        @Test
        @DisplayName("Ordenar array en orden inverso")
        void ordenarArrayInverso() {
            String[] nombres = {"Pedro", "Juan", "Ana"};
            double[] notas = {10, 5, 1};
            
            ArrayUtils.ordenarBurbuja(nombres, notas);
            
            assertArrayEquals(new double[]{1, 5, 10}, notas, 0.001);
            assertArrayEquals(new String[]{"Ana", "Juan", "Pedro"}, nombres);
        }

        @Test
        @DisplayName("Ordenar array con valores iguales")
        void ordenarArrayValoresIguales() {
            String[] nombres = {"Pedro", "Ana", "Juan"};
            double[] notas = {5, 5, 5};
            
            ArrayUtils.ordenarBurbuja(nombres, notas);
            
            assertArrayEquals(new double[]{5, 5, 5}, notas, 0.001);
        }

        @Test
        @DisplayName("Ordenar array de un solo elemento")
        void ordenarArrayUnElemento() {
            String[] nombres = {"Ana"};
            double[] notas = {5};
            
            ArrayUtils.ordenarBurbuja(nombres, notas);
            
            assertArrayEquals(new double[]{5}, notas, 0.001);
            assertArrayEquals(new String[]{"Ana"}, nombres);
        }

        @Test
        @DisplayName("Ordenar array de dos elementos")
        void ordenarArrayDosElementos() {
            String[] nombres = {"Pedro", "Ana"};
            double[] notas = {8, 3};
            
            ArrayUtils.ordenarBurbuja(nombres, notas);
            
            assertArrayEquals(new double[]{3, 8}, notas, 0.001);
            assertArrayEquals(new String[]{"Ana", "Pedro"}, nombres);
        }

        @Test
        @DisplayName("Ordenar array grande (10 elementos)")
        void ordenarArrayGrande() {
            String[] nombres = {"J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
            double[] notas = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            
            ArrayUtils.ordenarBurbuja(nombres, notas);
            
            assertArrayEquals(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, notas, 0.001);
            assertArrayEquals(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}, nombres);
        }

        @Test
        @DisplayName("Verificar que nombres se mantienen sincronizados con notas")
        void verificarSincronizacionNombresNotas() {
            String[] nombres = {"Pepe", "Luis", "Maria", "Carmen"};
            double[] notas = {7.5, 3.0, 9.0, 5.5};
            
            ArrayUtils.ordenarBurbuja(nombres, notas);
            
            assertEquals("Luis", nombres[0]);
            assertEquals(3.0, notas[0], 0.001);
            
            assertEquals("Carmen", nombres[1]);
            assertEquals(5.5, notas[1], 0.001);
            
            assertEquals("Pepe", nombres[2]);
            assertEquals(7.5, notas[2], 0.001);
            
            assertEquals("Maria", nombres[3]);
            assertEquals(9.0, notas[3], 0.001);
        }

        @Test
        @DisplayName("Ordenar con notas decimales")
        void ordenarConDecimales() {
            String[] nombres = {"C", "A", "B"};
            double[] notas = {5.75, 5.25, 5.50};
            
            ArrayUtils.ordenarBurbuja(nombres, notas);
            
            assertArrayEquals(new double[]{5.25, 5.50, 5.75}, notas, 0.001);
            assertArrayEquals(new String[]{"A", "B", "C"}, nombres);
        }
    }
}

