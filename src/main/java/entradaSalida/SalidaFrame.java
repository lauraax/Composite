/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entradaSalida;
import javax.swing.JOptionPane;
/**
 *
 * @author laura
 */
public class SalidaFrame extends Salida{
    @Override
    public void mostrarString(String dato) {
        JOptionPane.showMessageDialog(null, "String: " + dato);
    }

    @Override
    public void mostrarBoolean(boolean dato) {
        JOptionPane.showMessageDialog(null, "Boolean: " + dato);
    }

    @Override
    public void mostrarInt(int dato) {
        JOptionPane.showMessageDialog(null, "Int: " + dato);
    }

    @Override
    public void mostrarFloat(float dato) {
        JOptionPane.showMessageDialog(null, "Float: " + dato);
    }

    @Override
    public void mostrarDouble(double dato) {
        JOptionPane.showMessageDialog(null, "Double: " + dato);
    }

}
