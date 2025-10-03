package com.mycompany.composite;

// ConsoleDisplay.java
public class ConsoleDisplay implements TransporteDisplay {
    public void mostrar(Transporte transporte) {
        System.out.println(transporte.toString());
    }
}
