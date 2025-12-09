import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        App.datosIntroducidos = false;
        App.nombres = new String[App.NUM_ALUMNOS];
        App.notas = new double[App.NUM_ALUMNOS];
    }

    void restaurarSalida() {
        System.setOut(originalOut);
    }

    String obtenerSalida() {
        return outputStream.toString();
    }

    void inicializarDatosPrueba() {
        App.nombres = new String[]{"Ana", "Juan", "Pedro", "Maria", "Luis", "Carmen", "Pablo", "Laura", "Carlos", "Sofia"};
        App.notas = new double[]{5.0, 7.5, 3.0, 9.0, 6.5, 4.5, 8.0, 2.0, 10.0, 5.5};
        App.datosIntroducidos = true;
    }

    @Nested
    @DisplayName("Tests para comprobarDatosIntroducidos()")
    class ComprobarDatosTests {

        @Test
        @DisplayName("Debe devolver false si no hay datos introducidos")
        void sinDatosDevuelveFalse() {
            App.datosIntroducidos = false;
            boolean resultado = App.comprobarDatosIntroducidos();
            restaurarSalida();
            
            assertFalse(resultado);
            assertTrue(obtenerSalida().contains("Primero debes introducir los datos"));
        }

        @Test
        @DisplayName("Debe devolver true si hay datos introducidos")
        void conDatosDevuelveTrue() {
            App.datosIntroducidos = true;
            boolean resultado = App.comprobarDatosIntroducidos();
            restaurarSalida();
            
            assertTrue(resultado);
        }
    }

    @Nested
    @DisplayName("Tests para mostrarDatos()")
    class MostrarDatosTests {

        @Test
        @DisplayName("No debe mostrar datos si no se han introducido")
        void sinDatosNoMuestra() {
            App.datosIntroducidos = false;
            App.mostrarDatos();
            restaurarSalida();
            
            assertTrue(obtenerSalida().contains("Primero debes introducir los datos"));
        }

        @Test
        @DisplayName("Debe mostrar datos si se han introducido")
        void conDatosMuestra() {
            inicializarDatosPrueba();
            App.mostrarDatos();
            restaurarSalida();
            
            String salida = obtenerSalida();
            assertTrue(salida.contains("Ana"));
            assertTrue(salida.contains("Juan"));
        }
    }

    @Nested
    @DisplayName("Tests para calcularMedia()")
    class CalcularMediaTests {

        @Test
        @DisplayName("No debe calcular media si no hay datos")
        void sinDatosNoCalcula() {
            App.datosIntroducidos = false;
            App.calcularMedia();
            restaurarSalida();
            
            assertTrue(obtenerSalida().contains("Primero debes introducir los datos"));
        }

        @Test
        @DisplayName("Debe calcular y mostrar la media correctamente")
        void conDatosCalculaMedia() {
            inicializarDatosPrueba();
            App.calcularMedia();
            restaurarSalida();
            
            String salida = obtenerSalida();
            assertTrue(salida.contains("media"));
        }
    }

    @Nested
    @DisplayName("Tests para mostrarMaximoMinimo()")
    class MaximoMinimoTests {

        @Test
        @DisplayName("No debe mostrar si no hay datos")
        void sinDatosNoMuestra() {
            App.datosIntroducidos = false;
            App.mostrarMaximoMinimo();
            restaurarSalida();
            
            assertTrue(obtenerSalida().contains("Primero debes introducir los datos"));
        }

        @Test
        @DisplayName("Debe mostrar máximo y mínimo correctamente")
        void conDatosMuestraMaxMin() {
            inicializarDatosPrueba();
            App.mostrarMaximoMinimo();
            restaurarSalida();
            
            String salida = obtenerSalida();
            assertTrue(salida.contains("máxima") || salida.contains("Máxima") || salida.contains("10"));
            assertTrue(salida.contains("mínima") || salida.contains("Mínima") || salida.contains("2"));
        }
    }

    @Nested
    @DisplayName("Tests para contarAprobadosSuspensos()")
    class AprobadosSuspensosTests {

        @Test
        @DisplayName("No debe contar si no hay datos")
        void sinDatosNoCuenta() {
            App.datosIntroducidos = false;
            App.contarAprobadosSuspensos();
            restaurarSalida();
            
            assertTrue(obtenerSalida().contains("Primero debes introducir los datos"));
        }

        @Test
        @DisplayName("Debe contar aprobados y suspensos")
        void conDatosCuenta() {
            inicializarDatosPrueba();
            App.contarAprobadosSuspensos();
            restaurarSalida();
            
            String salida = obtenerSalida();
            assertTrue(salida.contains("probado") || salida.contains("uspenso") || salida.contains("orcentaje"));
        }
    }

    @Nested
    @DisplayName("Tests para ordenarPorNota()")
    class OrdenarTests {

        @Test
        @DisplayName("No debe ordenar si no hay datos")
        void sinDatosNoOrdena() {
            App.datosIntroducidos = false;
            App.ordenarPorNota();
            restaurarSalida();
            
            assertTrue(obtenerSalida().contains("Primero debes introducir los datos"));
        }

        @Test
        @DisplayName("Debe ordenar y mostrar datos ordenados")
        void conDatosOrdena() {
            inicializarDatosPrueba();
            App.ordenarPorNota();
            restaurarSalida();
            
            assertEquals(2.0, App.notas[0], 0.001);
            assertEquals("Laura", App.nombres[0]);
            assertEquals(10.0, App.notas[9], 0.001);
            assertEquals("Carlos", App.nombres[9]);
        }
    }

    @Nested
    @DisplayName("Tests para mostrarMenu()")
    class MenuTests {

        @Test
        @DisplayName("Debe mostrar el menú con todas las opciones")
        void muestraMenu() {
            App.mostrarMenu();
            restaurarSalida();
            
            String salida = obtenerSalida();
            assertTrue(salida.contains("GESTOR DE NOTAS"));
            assertTrue(salida.contains("1."));
            assertTrue(salida.contains("2."));
            assertTrue(salida.contains("0."));
        }
    }
}

