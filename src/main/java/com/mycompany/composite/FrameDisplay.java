package com.mycompany.composite;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.JOptionPane;

/**
 *
 * @author laura
 */
public class FrameDisplay implements TransporteDisplay {
    @Override
    public void mostrar(Transporte transporte) {
        JOptionPane.showMessageDialog(null, transporte.toString());
    }
}
