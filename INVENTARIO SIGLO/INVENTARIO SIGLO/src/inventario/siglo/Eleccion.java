package inventario.siglo;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Eleccion extends JFrame implements ChangeListener {
    private JLabel label1;
    private JRadioButton radioInsertar, radioBuscar;
    private ButtonGroup bg;
    private boolean abiertoInsertar = false, abiertoBuscar = false;

    public Eleccion() {
        setLayout(null);
        bg = new ButtonGroup();

        label1 = new JLabel("Selecciona una opción:");
        label1.setBounds(10, 10, 200, 30);
        add(label1);

        radioInsertar = new JRadioButton("Insertar");
        radioInsertar.setBounds(10, 50, 100, 30);
        radioInsertar.addChangeListener(this);
        add(radioInsertar);
        bg.add(radioInsertar);

        radioBuscar = new JRadioButton("Buscar");
        radioBuscar.setBounds(120, 50, 100, 30);
        radioBuscar.addChangeListener(this);
        add(radioBuscar);
        bg.add(radioBuscar);
    }

    public void stateChanged(ChangeEvent e) {
        if (radioInsertar.isSelected() && !abiertoInsertar) {
            Controlador_I cInsertar = new Controlador_I(); 
            cInsertar.iniciar();
            abiertoInsertar = true;
        }
        if (radioBuscar.isSelected() && !abiertoBuscar) {
            Controlador_B cBuscar = new Controlador_B(); 
            cBuscar.iniciar();
            abiertoBuscar = true;
        }
    }
}
