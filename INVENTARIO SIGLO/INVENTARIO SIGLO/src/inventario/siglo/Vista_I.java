package inventario.siglo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Vista_I extends JFrame {
    public JTextField textNombre, textID, textCargo, textArea, textEstado;
    public JLabel labelNombre, labelID, labelCargo, labelArea, labelEstado;
    public JButton btGuardar, btLimpiar, btSalir;
    public JTable tabla;
    public JScrollPane scrollpane1;
    public DefaultTableModel md;

    private String[] titulo = {"ID", "Nombre", "Cargo", "Área", "Estado"};

    public Vista_I() {
        setLayout(null);
        initComponents();
    }

    private void initComponents() {
        labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(50, 35, 100, 30);
        add(labelNombre);

        labelID = new JLabel("ID:");
        labelID.setBounds(50, 65, 100, 30);
        add(labelID);

        labelCargo = new JLabel("Cargo:");
        labelCargo.setBounds(50, 95, 100, 30);
        add(labelCargo);

        labelArea = new JLabel("Área:");
        labelArea.setBounds(50, 125, 100, 30);
        add(labelArea);

        labelEstado = new JLabel("Estado:");
        labelEstado.setBounds(50, 155, 100, 30);
        add(labelEstado);

        textNombre = new JTextField();
        textNombre.setBounds(150, 35, 150, 20);
        add(textNombre);

        textID = new JTextField();
        textID.setBounds(150, 65, 150, 20);
        add(textID);

        textCargo = new JTextField();
        textCargo.setBounds(150, 95, 150, 20);
        add(textCargo);

        textArea = new JTextField();
        textArea.setBounds(150, 125, 150, 20);
        add(textArea);

        textEstado = new JTextField();
        textEstado.setBounds(150, 155, 150, 20);
        add(textEstado);

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
