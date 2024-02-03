/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package triangulo;

import java.util.Scanner;

/**
 *
 * @author LabP3E003
 */
public class Triangulo {
    private double lado1, lado2, lado3;

    public Triangulo(double lado1, double lado2, double lado3){
        this.lado1=lado1;
        this.lado2=lado2;
        this.lado3=lado3;
    }

    public double calcularArea() {
        // Fórmula de Herón para calcular el área de un triángulo
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }


    public String determinarTipo() {
        if (lado1 == lado2 && lado2 == lado3) {
            return "Equilátero";
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }
}
