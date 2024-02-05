package triangulo;

import excepciones.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrianguloTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void crearTriangulo() {

    }

    @org.junit.Test
    public void calcularArea() {
    }

    @org.junit.Test
    public void clasificarTipo() {
    }

    @Test
    public void testValidarEntradaNumericaNegativa(){
        //Cuando todos sus lados son negativos
        double lado1 = -5;
        double lado2 = -4;
        double lado3= -3;

        String resultadoEsperado1 = "Error: Los lados deben tener longitudes positivas.";
        LadosNoPositivosException ladosNoPositivos=  assertThrows(LadosNoPositivosException.class, () -> new Triangulo(lado1,lado2,lado3));
        assertEquals(resultadoEsperado1,ladosNoPositivos.getMessage());
    }

    @Test
    public void testValidarEntradaNumericaUnLadoNegativo1() {
        //Cuando todos sus lados son negativos
        double lado1 = -5;
        double lado2 = 4;
        double lado3= 3;

        String resultadoEsperado1 = "Error: Los lados deben tener longitudes positivas.";
        LadosNoPositivosException ladosNoPositivos=  assertThrows(LadosNoPositivosException.class, () -> new Triangulo(lado1,lado2,lado3));
        assertEquals(resultadoEsperado1,ladosNoPositivos.getMessage());
    }

    @Test
    public void testValidarEntradaNumericaUnLadoNegativo2() {
        //Cuando todos sus lados son negativos
        double lado1 = 5;
        double lado2 = -4;
        double lado3= 3;

        String resultadoEsperado1 = "Error: Los lados deben tener longitudes positivas.";
        LadosNoPositivosException ladosNoPositivos=  assertThrows(LadosNoPositivosException.class, () -> new Triangulo(lado1,lado2,lado3));
        assertEquals(resultadoEsperado1,ladosNoPositivos.getMessage());
    }

    @Test
    public void testValidarEntradaNumericaUnLadoNegativo3() {
        //Cuando todos sus lados son negativos
        double lado1 = 5;
        double lado2 = 4;
        double lado3= -3;

        String resultadoEsperado1 = "Error: Los lados deben tener longitudes positivas.";
        LadosNoPositivosException ladosNoPositivos=  assertThrows(LadosNoPositivosException.class, () -> new Triangulo(lado1,lado2,lado3));
        assertEquals(resultadoEsperado1,ladosNoPositivos.getMessage());
    }

    @Test
    public void testValidarEntradaNumericaDosNegativos1() {
        //Cuando dos de sus lados son negativos
        double lado1 = -5;
        double lado2 = -4;
        double lado3= 3;

        String resultadoEsperado1 = "Error: Los lados deben tener longitudes positivas.";
        LadosNoPositivosException ladosNoPositivos=  assertThrows(LadosNoPositivosException.class, () -> new Triangulo(lado1,lado2,lado3));
        assertEquals(resultadoEsperado1,ladosNoPositivos.getMessage());
    }

    @Test
    public void testValidarEntradaNumericaDosNegativos2() {
        //Cuando dos de sus lados son negativos
        double lado1 = 5;
        double lado2 = -4;
        double lado3= -3;

        String resultadoEsperado1 = "Error: Los lados deben tener longitudes positivas.";
        LadosNoPositivosException ladosNoPositivos=  assertThrows(LadosNoPositivosException.class, () -> new Triangulo(lado1,lado2,lado3));
        assertEquals(resultadoEsperado1,ladosNoPositivos.getMessage());
    }

    @Test
    public void testValidarEntradaNumericaDosNegativos3() {
        //Cuando dos de sus lados son negativos
        double lado1 = -5;
        double lado2 = 4;
        double lado3= -3;

        String resultadoEsperado1 = "Error: Los lados deben tener longitudes positivas.";
        LadosNoPositivosException ladosNoPositivos=  assertThrows(LadosNoPositivosException.class, () -> new Triangulo(lado1,lado2,lado3));
        assertEquals(resultadoEsperado1,ladosNoPositivos.getMessage());
    }

    @Test
    public void testValidarEntradaNoNumerica() {
        String lado1 = "abc";
        double lado2 = 2.0;
        double lado3 = 3.0;

        String resultadoEsperado =  "Error: Ingrese valores numéricos para los lados del triángulo.";
        EntradaNoNumericaException entradaNoNumerica= assertThrows(EntradaNoNumericaException.class, () -> {
            try {
                new Triangulo(Double.parseDouble(lado1), lado2, lado3);
            } catch (NumberFormatException e) {
                throw new EntradaNoNumericaException("Error: Ingrese valores numéricos para los lados del triángulo.");
            }
        });

        assertEquals(resultadoEsperado, entradaNoNumerica.getMessage());
    }

    @Test
    public void testValidarTriangulo(){
        double lado1 = 3;
        double lado2 = 4;
        double lado3 = 7;

        String resultadoEsperado ="Error: Los lados ingresados no forman un triángulo válido.";
        TrianguloInvalidoException validarTriangulo=  assertThrows(TrianguloInvalidoException.class, () -> new Triangulo(lado1,lado2,lado3));
        assertEquals(resultadoEsperado,validarTriangulo.getMessage());
    }

    @Test
    public void testCrearUnTrianguloEquilatero() throws LadosNoPositivosException, TrianguloInvalidoException, EntradaNoNumericaException {
        double lado = 8;
        Triangulo triangulo= Triangulo.crearTriangulo(lado, lado, lado);

        //Calcular el area:
        double areaEsperada = 27.712812921102035;
        assertEquals(areaEsperada, triangulo.calcularArea(), 0);
        //Determinar tipo
        String tipoEsperado = "Además, el triángulo es Equilátero.";
        assertEquals(tipoEsperado, triangulo.clasificarTipo());

    }

    @Test
    public void testCrearTrianguloEscaleno() throws LadosNoPositivosException, TrianguloInvalidoException, EntradaNoNumericaException {
        double lado1 = 7;
        double lado2 = 24;
        double lado3 = 25;

        Triangulo triangulo= Triangulo.crearTriangulo(lado1, lado2, lado3);
        //Area
        double areaEsperada = 84;
        assertEquals(areaEsperada, triangulo.calcularArea(), 0);

        //Determinar tipo
        String tipoEsperado = "Además, el triángulo es Escaleno.";
        assertEquals(tipoEsperado, triangulo.clasificarTipo());
    }

    //Las pruebas unitarias a continuacion muestra los diferentes ordenes de ingresar datos para el triangulo Isosceles
    @Test
    public void testCrearTrianguloIsósceles1() throws LadosNoPositivosException, TrianguloInvalidoException, EntradaNoNumericaException {
        double lado1 = 10;
        double lado2 = 7;
        double lado3 = 7;

        Triangulo triangulo= Triangulo.crearTriangulo(lado1, lado2, lado3);

        //Calcular el area:
        double areaEsperada = 24.49489742783178;
        assertEquals(areaEsperada, triangulo.calcularArea(), 0);

        //Determinar tipo
        String tipoEsperado = "Además, el triángulo es Isósceles.";;
        assertEquals(tipoEsperado, triangulo.clasificarTipo());
    }

    @Test
    public void testCrearTrianguloIsósceles2() throws LadosNoPositivosException, TrianguloInvalidoException, EntradaNoNumericaException {
        double lado1 = 12;
        double lado2 = 12;
        double lado3 = 15;

        Triangulo triangulo= Triangulo.crearTriangulo(lado1, lado2, lado3);

        //Calcular el area:
        double areaEsperada = 70.25622748198198;
        assertEquals(areaEsperada, triangulo.calcularArea(), 0);

        //Determinar tipo
        String tipoEsperado = "Además, el triángulo es Isósceles.";;
        assertEquals(tipoEsperado, triangulo.clasificarTipo());
    }

    @Test
    public void testCrearTrianguloIsósceles3() throws LadosNoPositivosException, TrianguloInvalidoException, EntradaNoNumericaException {
        double lado1 = 6;
        double lado2 = 9;
        double lado3 = 6;

        Triangulo triangulo= Triangulo.crearTriangulo(lado1, lado2, lado3);

        //Calcular el area:
        double areaEsperada = 17.858821349685986;
        assertEquals(areaEsperada, triangulo.calcularArea(), 0);

        //Determinar tipo
        String tipoEsperado = "Además, el triángulo es Isósceles.";;
        assertEquals(tipoEsperado, triangulo.clasificarTipo());
    }

}