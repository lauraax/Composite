package entradaSalida;

import java.util.Scanner;


public class EntradaConsola extends Entrada{

    private final Scanner sc = new Scanner(System.in);

    @Override
    public String ingresarString(String mensaje) {
        System.out.print(mensaje + ": ");
        return sc.nextLine();
    }
    
    @Override
    public boolean ingresarBoolean(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (true/false): ");
            String input = sc.nextLine().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("Por favor, ingrese 'true' o 'false'.");
        }
    }
    
    @Override
    public int ingresarInt(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
            }
        }
    }
    
    @Override
    public float ingresarFloat(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            try {
                return Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número decimal válido.");
            }
        }
    }
    
    @Override
    public double ingresarDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número decimal válido.");
            }
        }
    }

}
