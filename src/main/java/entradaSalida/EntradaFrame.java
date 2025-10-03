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
public class EntradaFrame extends Entrada{
        @Override
        public String ingresarString(String mensaje) {
            return JOptionPane.showInputDialog(null, mensaje);
        }

        @Override
        public boolean ingresarBoolean(String mensaje) {
            String input = JOptionPane.showInputDialog(null, mensaje + " (true/false)");
            return Boolean.parseBoolean(input);
        }

        @Override
        public int ingresarInt(String mensaje) {
            String input = JOptionPane.showInputDialog(null, mensaje);
            return Integer.parseInt(input);
        }

        @Override
        public float ingresarFloat(String mensaje) {
            String input = JOptionPane.showInputDialog(null, mensaje);
            return Float.parseFloat(input);
        }

        @Override
        public double ingresarDouble(String mensaje) {
            String input = JOptionPane.showInputDialog(null, mensaje);
            return Double.parseDouble(input);
        }
    }

