/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package triangulo;

import excepciones.EntradaNoNumericaException;
import excepciones.LadosNoPositivosException;
import excepciones.TrianguloInvalidoException;

/**
 *
 * @author LabP3E003
 */
public class TrianguloEscaleno extends Triangulo{
    
    public TrianguloEscaleno(double lado1, double lado2, double lado3) throws LadosNoPositivosException, TrianguloInvalidoException, EntradaNoNumericaException {
        super(lado1, lado2, lado3);
    }

    @Override
    public String clasificarTipo() {
        return "Además, el triángulo es Escaleno.";
    }



}
