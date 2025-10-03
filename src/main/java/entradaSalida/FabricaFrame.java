/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entradaSalida;


public class FabricaFrame extends FabricaEntradaSalida {
    @Override
    public Entrada generarEntrada() {
        return new EntradaFrame();
    }

    @Override
    public Salida generarSalida() {
        return new SalidaFrame();
    }

}

