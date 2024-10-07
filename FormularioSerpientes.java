import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormularioSerpientes extends JFrame {
    private JTextField nombreCientificoField;
    private JTextField esperanzaVidaField;
    private JTextField temperaturaCorporalField;
    private JTextField cantidadHuevosField;
    private JTextField longitudField;
    private JTextField especieField;
    private JTextField colorPielField;
    private JCheckBox tipoVenenoCheckBox;
    private JButton guardarButton;

    public FormularioSerpientes() {
        setTitle("Formulario Serpientes");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        nombreCientificoField = new JTextField();
        esperanzaVidaField = new JTextField();
        temperaturaCorporalField = new JTextField();
        cantidadHuevosField = new JTextField();
        longitudField = new JTextField();
        especieField = new JTextField();
        colorPielField = new JTextField();
        tipoVenenoCheckBox = new JCheckBox("Tipo Veneno");
        guardarButton = new JButton("Guardar");

        nombreCientificoField.setBounds(150, 20, 200, 30);
        esperanzaVidaField.setBounds(150, 60, 200, 30);
        temperaturaCorporalField.setBounds(150, 100, 200, 30);
        cantidadHuevosField.setBounds(150, 140, 200, 30);
        longitudField.setBounds(150, 180, 200, 30);
        especieField.setBounds(150, 220, 200, 30);
        colorPielField.setBounds(150, 260, 200, 30);
        guardarButton.setBounds(150, 300, 200, 30);

        add(new JLabel("Nombre Científico:")).setBounds(20, 20, 120, 30);
        add(new JLabel("Esperanza de Vida:")).setBounds(20, 60, 120, 30);
        add(new JLabel("Temperatura Corporal:")).setBounds(20, 100, 120, 30);
        add(new JLabel("Cantidad de Huevos:")).setBounds(20, 140, 120, 30);
        add(new JLabel("Longitud:")).setBounds(20, 180, 120, 30);
        add(new JLabel("Especie:")).setBounds(20, 220, 120, 30);
        add(new JLabel("Color de Piel:")).setBounds(20, 260, 120, 30);
        add(tipoVenenoCheckBox);
        add(guardarButton);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double longitud = Double.parseDouble(longitudField.getText());
                String especie = especieField.getText();
                String colorPiel = colorPielField.getText();
                boolean tipoVeneno = tipoVenenoCheckBox.isSelected();

                Serpientes serpiente = new Serpientes(
                        nombreCientificoField.getText(),
                        Integer.parseInt(esperanzaVidaField.getText()),
                        Integer.parseInt(temperaturaCorporalField.getText()),
                        Integer.parseInt(cantidadHuevosField.getText()),
                        longitud, especie, colorPiel, tipoVeneno);

                List<Serpientes> serpientes = new ArrayList<>();
                serpientes.add(serpiente);

                LeerCSV leerCSV = new LeerCSV("data/Serpientes.csv");
                leerCSV.GuardarSerpientes(serpientes);

                JOptionPane.showMessageDialog(null, "Serpiente guardada.");
            }
        });

        setVisible(true);
    }
}
