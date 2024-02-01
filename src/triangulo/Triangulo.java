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

    public static double calcularAreaTriangulo(double lado1, double lado2, double lado3) {
        double semiPerimetro = (lado1 + lado2 + lado3) / 2;

        // Fórmula de Herón para el área del triángulo
        double area = Math.sqrt(semiPerimetro * (semiPerimetro - lado1) * (semiPerimetro - lado2) * (semiPerimetro - lado3));

        return area;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese el lado 1 del triángulo: ");
            double lado1 = scanner.nextDouble();

            System.out.println("Ingrese el lado 2 del triángulo: ");
            double lado2 = scanner.nextDouble();

            System.out.println("Ingrese el lado 3 del triángulo: ");
            double lado3 = scanner.nextDouble();


            double area = calcularAreaTriangulo(lado1, lado2, lado3);
            System.out.println("El área del triángulo es: " + area);


            System.out.println("¿Desea calcular el área de otro triángulo? (Ingrese 'si' para continuar, 'no' para salir): ");
            String respuesta = scanner.next().toLowerCase();

            if (respuesta.equals("no")) {
                continuar = false;
            }
        }
    }
    
}
