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

public class Controlador_I implements ActionListener {
    private final Vista_I view;
    private final Conexion conexion;

    public Controlador_I() {
        this.view = new Vista_I();
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
            guardarEmpleado();
        } else if (e.getSource() == view.btLimpiar) {
            limpiarCampos();
        }
    }

    private void guardarEmpleado() {
        String sql = "INSERT INTO empleados (id, nombre, cargo, area, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn = conexion.conexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, view.textID.getText());
            ps.setString(2, view.textNombre.getText());
            ps.setString(3, view.textCargo.getText());
            ps.setString(4, view.textArea.getText());
            ps.setString(5, view.textEstado.getText());

            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Empleado Guardado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
        }
    }

    private void limpiarCampos() {
        view.textNombre.setText("");
        view.textID.setText("");
        view.textCargo.setText("");
        view.textArea.setText("");
        view.textEstado.setText("");
    }
}

