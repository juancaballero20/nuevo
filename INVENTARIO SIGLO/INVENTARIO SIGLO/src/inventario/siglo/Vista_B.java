/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.siglo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Vista_B extends JFrame {
    public JTextField textMarca, textModelo, textSerial, textProcesador, textRam, textDisco, textSO;
    public JLabel labelMarca, labelModelo, labelSerial, labelProcesador, labelRam, labelDisco, labelSO;
    public JButton btGuardar, btLimpiar, btSalir;
    public JTable tabla;
    public JScrollPane scrollpane1;
    public DefaultTableModel md;

    private String[] titulo = {"Marca", "Modelo", "Serial", "Procesador", "RAM", "Disco", "SO"};

    public Vista_B() {
        setLayout(null);
        initComponents();
    }

    private void initComponents() {
        labelMarca = new JLabel("Marca:");
        labelMarca.setBounds(50, 35, 100, 30);
        add(labelMarca);

        labelModelo = new JLabel("Modelo:");
        labelModelo.setBounds(50, 65, 100, 30);
        add(labelModelo);

        labelSerial = new JLabel("Serial:");
        labelSerial.setBounds(50, 95, 100, 30);
        add(labelSerial);

        labelProcesador = new JLabel("Procesador:");
        labelProcesador.setBounds(50, 125, 100, 30);
        add(labelProcesador);

        labelRam = new JLabel("RAM:");
        labelRam.setBounds(50, 155, 100, 30);
        add(labelRam);

        textMarca = new JTextField();
        textMarca.setBounds(150, 35, 150, 20);
        add(textMarca);

        textModelo = new JTextField();
        textModelo.setBounds(150, 65, 150, 20);
        add(textModelo);

        textSerial = new JTextField();
        textSerial.setBounds(150, 95, 150, 20);
        add(textSerial);

        textProcesador = new JTextField();
        textProcesador.setBounds(150, 125, 150, 20);
        add(textProcesador);

        textRam = new JTextField();
        textRam.setBounds(150, 155, 150, 20);
        add(textRam);

        tabla = new JTable();
        scrollpane1 = new JScrollPane(tabla);
        scrollpane1.setBounds(10, 230, 500, 200);
        add(scrollpane1);

        btGuardar = new JButton("Guardar");
        btGuardar.setBounds(50, 450, 100, 30);
        add(btGuardar);

        btLimpiar = new JButton("Limpiar");
        btLimpiar.setBounds(200, 450, 100, 30);
        add(btLimpiar);

        btSalir = new JButton("Salir");
        btSalir.setBounds(350, 450, 100, 30);
        add(btSalir);
    }
}
