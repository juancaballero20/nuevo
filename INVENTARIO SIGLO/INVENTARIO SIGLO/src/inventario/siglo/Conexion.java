/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.siglo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane; // Importación necesaria

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/inventario_siglo";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection conect = null;

    public Connection conexion() {
        try {
            // Cargamos el Driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecemos la conexión
            conect = DriverManager.getConnection(URL, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexión exitosa");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el driver: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conect;
    }
    
    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (conect != null) {
                conect.close();
                JOptionPane.showMessageDialog(null, "Conexión cerrada");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
                