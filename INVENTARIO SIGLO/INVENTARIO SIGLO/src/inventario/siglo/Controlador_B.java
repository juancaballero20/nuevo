/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.siglo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

public class Controlador_B implements ActionListener {
    private final Vista_B view;
    private final Conexion conexion;

    public Controlador_B() {
        this.view = new Vista_B();
        this.conexion = new Conexion();
        addListeners();
    }

    public void iniciar() {
        view.setBounds(0, 0, 600, 600);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.setResizable(false);
    }

    private void addListeners() {
        view.btGuardar.addActionListener(this);
        view.btLimpiar.addActionListener(this);
        view.btSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btSalir) {
            System.exit(0);
        } else if (e.getSource() == view.btGuardar) {
            guardarComputadora();
        } else if (e.getSource() == view.btLimpiar) {
            limpiarCampos();
        }
    }

    private void guardarComputadora() {
        String sql = "INSERT INTO computadoras (marca, modelo, serial, procesador, ram, disco, so) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = conexion.conexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, view.textMarca.getText());
            ps.setString(2, view.textModelo.getText());
            ps.setString(3, view.textSerial.getText());
            ps.setString(4, view.textProcesador.getText());
            ps.setString(5, view.textRam.getText());
            ps.setString(6, view.textDisco.getText());
            ps.setString(7, view.textSO.getText());

            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Computadora Guardada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
        }
    }

    private void limpiarCampos() {
        view.textMarca.setText("");
        view.textModelo.setText("");
        view.textSerial.setText("");
        view.textProcesador.setText("");
        view.textRam.setText("");
        view.textDisco.setText("");
        view.textSO.setText("");
    }
}

