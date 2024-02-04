package triangulo;

import excepciones.EntradaNoNumericaException;
import excepciones.LadosNoPositivosException;
import excepciones.TrianguloInvalidoException;

import javax.swing.*;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static {
        try {
            // Configuración del logger
            logger.setLevel(Level.ALL);

            // Configurar un FileHandler para enviar mensajes a un archivo
            // Obtener la ruta del archivo de log
            Path currentPath = Path.of("");
            String logPath = currentPath.toAbsolutePath().toString() + "\\src\\triangulo\\log.txt";
            System.out.println("Log path: " + logPath);
            FileHandler fileHandler = new FileHandler( logPath, true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            System.out.println("Logger configurado");
            // Remover el ConsoleHandler
            logger.setUseParentHandlers(false);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pudo configurar el Logger", e);
        }
    }
    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            Triangulo triangulo = null;
            do {
                try {
                    double lado1 = obtenerDouble("Ingrese la longitud del lado 1 del triángulo:");
                    double lado2 = obtenerDouble("Ingrese la longitud del lado 2 del triángulo:");
                    double lado3 = obtenerDouble("Ingrese la longitud del lado 3 del triángulo:");

                    triangulo = Triangulo.crearTriangulo(lado1, lado2, lado3);

                } catch (LadosNoPositivosException | TrianguloInvalidoException | EntradaNoNumericaException e) {
                    logger.log(Level.SEVERE, "Excepción al crear el triángulo", e);
                    mostrarMensaje(e.getMessage() + "\nPor favor, ingrese los valores nuevamente.");
                }
            } while (triangulo == null); // Repetir el bucle si la creación del triángulo lanzó una excepción

            double area = triangulo.calcularArea();

            mostrarMensaje("El área del triángulo es: " + area + " \n" + triangulo.clasificarTipo());

            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea analizar otro triángulo?", "Confirmación", JOptionPane.YES_NO_OPTION);

            continuar = (opcion == JOptionPane.YES_OPTION);
        }
    }

    private static double obtenerDouble(String mensaje) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(mensaje);
                if (input == null) {
                    System.exit(0); // Si el usuario cancela la entrada, termina el programa
                }
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                // Registra la excepción en el Logger
                logger.log(Level.SEVERE, "Excepción al obtener un valor double", e);
                mostrarMensaje("Error: Ingrese un valor numérico válido.");
            }
        }
    }

    private static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
