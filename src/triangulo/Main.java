package triangulo;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {

            double lado1 = obtenerDouble("Ingrese la longitud del lado 1 del triángulo:");
            double lado2 = obtenerDouble("Ingrese la longitud del lado 2 del triángulo:");
            double lado3 = obtenerDouble("Ingrese la longitud del lado 3 del triángulo:");

            Triangulo triangulo = Triangulo.crearTriangulo(lado1, lado2, lado3);

            double area = triangulo.calcularArea();


            mostrarMensaje("El área del triángulo es: " + area + " \n" + triangulo.clasificarTipo());

            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea analizar otro triángulo?", "Confirmación", JOptionPane.YES_NO_OPTION);

            continuar = (opcion == JOptionPane.YES_OPTION);
        }
    }

    private static double obtenerDouble(String mensaje) {
        return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
    }

    private static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
