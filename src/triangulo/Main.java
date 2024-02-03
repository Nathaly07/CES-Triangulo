package triangulo;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            double lado1 = obtenerLongitudLado("Ingrese la longitud del lado 1 del triángulo:");
            double lado2 = obtenerLongitudLado("Ingrese la longitud del lado 2 del triángulo:");
            double lado3 = obtenerLongitudLado("Ingrese la longitud del lado 3 del triángulo:");

            Triangulo triangulo;

            if (lado1 == lado2 && lado2 == lado3) {
                triangulo = new TrianguloEquilátero(lado1);
            } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                triangulo = new TrianguloIsósceles(lado1, lado2);
            } else {
                triangulo = new TrianguloEscaleno(lado1, lado2, lado3);
            }

            double area = triangulo.calcularArea();
            String tipo = triangulo.determinarTipo();

            mostrarMensaje("El área del triángulo es: " + area + "\nEl triángulo es de tipo: " + tipo);


            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea analizar otro triángulo?", "Confirmación", JOptionPane.YES_NO_OPTION);

            continuar = (opcion == JOptionPane.YES_OPTION);
        }
    }

    private static double obtenerLongitudLado(String mensaje) {
        return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
    }

    private static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

}
