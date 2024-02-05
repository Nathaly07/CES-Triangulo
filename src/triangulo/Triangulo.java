/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package triangulo;

import excepciones.EntradaNoNumericaException;
import excepciones.LadosNoPositivosException;
import excepciones.TrianguloInvalidoException;

import javax.swing.*;
import java.util.Scanner;

/**
 *
 * @author LabP3E003
 */
class Triangulo {
    protected double lado1;
    protected double lado2;
    protected double lado3;

    public Triangulo(double lado1, double lado2, double lado3) throws EntradaNoNumericaException, TrianguloInvalidoException, LadosNoPositivosException {
        validarEntradaNumerica(lado1, lado2, lado3);
        validarLadosPositivos(lado1, lado2, lado3);
        validarTriangulo(lado1, lado2, lado3);

        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public static Triangulo crearTriangulo(double lado1, double lado2, double lado3) throws LadosNoPositivosException, TrianguloInvalidoException, EntradaNoNumericaException {
        if (lado1 == lado2 && lado2 == lado3) {
            return new TrianguloEquilátero(lado1);
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            return new TrianguloIsósceles(lado1, lado2, lado3);
        } else {
            return new TrianguloEscaleno(lado1, lado2, lado3);
        }
    }

    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    public String clasificarTipo() {

        return "Este triangulo no se pudo clasificar";

    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void validarEntradaNumerica(double lado1, double lado2, double lado3) throws EntradaNoNumericaException {
        try {
            Double.parseDouble(String.valueOf(lado1));
            Double.parseDouble(String.valueOf(lado2));
            Double.parseDouble(String.valueOf(lado3));
        } catch (NumberFormatException e) {
            throw new EntradaNoNumericaException("Error: Ingrese valores numéricos para los lados del triángulo.");
        }
    }

    private void validarTriangulo(double lado1, double lado2, double lado3) throws TrianguloInvalidoException {
        if (!esTrianguloValido(lado1, lado2, lado3)) {
            throw new TrianguloInvalidoException("Error: Los lados ingresados no forman un triángulo válido.");
        }
    }

    private void validarLadosPositivos(double lado1, double lado2, double lado3) throws LadosNoPositivosException {
        if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
            throw new LadosNoPositivosException("Error: Los lados deben tener longitudes positivas.");
        }
    }

    // Método para verificar si los lados forman un triángulo válido
    private boolean esTrianguloValido(double lado1, double lado2, double lado3) {
        return lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1;
    }


}

