/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package triangulo;

/**
 *
 * @author LabP3E003
 */
public class TrianguloIsósceles extends Triangulo{

    public TrianguloIsósceles(double lado1, double lado2) {
        super(lado1, lado2, lado2);
    }

    @Override
    public String determinarTipo() {
        return "Isósceles";
    }
}

