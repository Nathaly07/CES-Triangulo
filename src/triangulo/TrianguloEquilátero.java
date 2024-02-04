/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package triangulo;

/**
 *
 * @author LabP3E003
 */
public class TrianguloEquilátero extends Triangulo{
    private double lado;

    public TrianguloEquilátero(double lado) {
        super(lado, lado, lado);
        this.lado = lado;
    }

    @Override
    public String clasificarTipo() {
        return "Además, el triángulo es Equilátero.";
    }

    @Override
    public double calcularArea() {
        return (Math.sqrt(3)/4)*lado*lado;
    }

}
