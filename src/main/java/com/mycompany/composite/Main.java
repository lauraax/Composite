package com.mycompany.composite;


// Main.java (Actualizado para usar métodos de tipos en Entrada/Salida)
// Main.java (Actualizado para usar métodos de tipos en Entrada/Salida)
import entradaSalida.Entrada;
import entradaSalida.FabricaEntradaSalida;
import entradaSalida.FabricaConsola;
import entradaSalida.FabricaFrame;
import entradaSalida.Salida;

import javax.swing.*;
import java.util.List;

public class Main {
    private static Flota flotaPrincipal;
    private static Entrada entrada;
    private static Salida salida;

    public static void main(String[] args) {
        // Lanzar la ventana inicial para elegir modo de entrada/salida
        SwingUtilities.invokeLater(SeleccionModo::new);
    }

    // Método para inicializar el sistema después de elegir el modo
    public static void inicializar(FabricaEntradaSalida factory) {
        entrada = factory.generarEntrada();
        salida = factory.generarSalida();

        // Inicializar flota principal 
        flotaPrincipal = new Flota.Builder()
                .modelo("Flota Principal")
                .fabricante("OperatorInc")
                .capacidadPasajeros(234)
                .autonomia(11000.0)
                .display(new ConsoleDisplay()) // Display por defecto, se cambia al mostrar
                .build();

        // Bucle del menú principal
        boolean salir = false;
        while (!salir) {
            salida.mostrarString("Menú:\n1. Agregar transporte nuevo\n2. Editar transporte\n3. Mostrar transportes\n4. Salir");
            String opcion = entrada.ingresarString("Ingrese opción");

            switch (opcion) {
                case "1":
                    agregarTransporte();
                    break;
                case "2":
                    editarTransporte();
                    break;
                case "3":
                    mostrarTransportes();
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    salida.mostrarString("Opción no válida.");
            }
        }
    }

    private static void agregarTransporte() {
        String tipo = entrada.ingresarString("Tipo de transporte: 1) Avion 2) Barco");
        String modelo = entrada.ingresarString("Modelo");
        String fabricante = entrada.ingresarString("Fabricante");
        int capacidad = entrada.ingresarInt("Capacidad de pasajeros");
        double autonomia = entrada.ingresarDouble("Autonomía");

        TransportFactory factory = "1".equals(tipo) ? new AvionFactory() : new BarcoFactory();
        Transporte nuevo = factory.crearTransporte(modelo, fabricante, capacidad, autonomia, null); // Display se setea después
        flotaPrincipal.agregar(nuevo);
        salida.mostrarString("Transporte agregado.");
    }

    private static void editarTransporte() {
        List<Transporte> componentes = flotaPrincipal.getComponentes();
        if (componentes.isEmpty()) {
            salida.mostrarString("No hay transportes para editar.");
            return;
        }

        StringBuilder sb = new StringBuilder("Seleccione transporte a editar:\n");
        for (int i = 0; i < componentes.size(); i++) {
            sb.append((i + 1)).append(". ").append(componentes.get(i).toString()).append("\n");
        }
        salida.mostrarString(sb.toString());

        int index = entrada.ingresarInt("Índice") - 1;
        if (index < 0 || index >= componentes.size()) {
            salida.mostrarString("Índice no válido.");
            return;
        }

        Transporte t = componentes.get(index);
        t.modelo = entrada.ingresarString("Nuevo modelo (actual: " + t.modelo + ")");
        t.fabricante = entrada.ingresarString("Nuevo fabricante (actual: " + t.fabricante + ")");
        t.capacidadPasajeros = entrada.ingresarInt("Nueva capacidad (actual: " + t.capacidadPasajeros + ")");
        t.autonomia = entrada.ingresarDouble("Nueva autonomía (actual: " + t.autonomia + ")");
        salida.mostrarString("Transporte editado.");
    }

    private static void mostrarTransportes() {
        String optSalida = entrada.ingresarString("Seleccione tipo de salida: 1) Consola 2) Frame");
        TransporteDisplay display = "2".equals(optSalida) ? new FrameDisplay() : new ConsoleDisplay();

        flotaPrincipal.setDisplay(display);
        salida.mostrarString("== Flota ==");
        flotaPrincipal.mostrarInformacion();
    }
}