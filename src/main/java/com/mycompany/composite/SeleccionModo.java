package com.mycompany.composite;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// SeleccionModo.java (Nuevo archivo para la ventana inicial con JRadioButtons)
import com.mycompany.composite.Main;
import entradaSalida.FabricaConsola;
import entradaSalida.FabricaEntradaSalida;
import entradaSalida.FabricaFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionModo extends JFrame implements ActionListener {
    private JRadioButton consolaRadio;
    private JRadioButton frameRadio;
    private JButton confirmarButton;

    public SeleccionModo() {
        setTitle("Seleccione Modo de Entrada/Salida");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        consolaRadio = new JRadioButton("Consola");
        consolaRadio.setBounds(50, 20, 100, 30);
        frameRadio = new JRadioButton("Frame");
        frameRadio.setBounds(150, 20, 100, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(consolaRadio);
        group.add(frameRadio);

        confirmarButton = new JButton("Confirmar");
        confirmarButton.setBounds(100, 60, 100, 30);
        confirmarButton.addActionListener(this);

        add(consolaRadio);
        add(frameRadio);
        add(confirmarButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmarButton) {
            FabricaEntradaSalida factory;
            if (consolaRadio.isSelected()) {
                factory = new FabricaConsola();
            } else if (frameRadio.isSelected()) {
                factory = new FabricaFrame();
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una opción.");
                return;
            }
            dispose(); // Cerrar la ventana
            Main.inicializar(factory); // Iniciar el menú principal
        }
    }
}
