/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package triangulo;

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

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public static Triangulo crearTriangulo(double lado1, double lado2, double lado3) {
        if (lado1 == lado2 && lado2 == lado3) {
            return new TrianguloEquilátero(lado1);
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            return new TrianguloIsósceles(lado1, lado2);
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
}

