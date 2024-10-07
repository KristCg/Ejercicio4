import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioReptilesAcuaticos extends JFrame {
    private JTextField nombreCientificoField;
    private JTextField esperanzaVidaField;
    private JTextField temperaturaCorporalField;
    private JTextField cantidadHuevosField;
    private JTextField longitudField;
    private JTextField especieField;
    private JCheckBox tipoAguaCheckBox;
    private JTextField velocidadNadoField;
    private JTextField duracionBuceoField;
    private JButton guardarButton;

    public FormularioReptilesAcuaticos() {
        setTitle("Formulario Reptiles Acuáticos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        nombreCientificoField = new JTextField();
        esperanzaVidaField = new JTextField();
        temperaturaCorporalField = new JTextField();
        cantidadHuevosField = new JTextField();
        longitudField = new JTextField();
        especieField = new JTextField();
        tipoAguaCheckBox = new JCheckBox("Tipo Agua");
        velocidadNadoField = new JTextField();
        duracionBuceoField = new JTextField();
        guardarButton = new JButton("Guardar");

        nombreCientificoField.setBounds(150, 20, 200, 30);
        esperanzaVidaField.setBounds(150, 60, 200, 30);
        temperaturaCorporalField.setBounds(150, 100, 200, 30);
        cantidadHuevosField.setBounds(150, 140, 200, 30);
        longitudField.setBounds(150, 180, 200, 30);
        especieField.setBounds(150, 220, 200, 30);
        tipoAguaCheckBox.setBounds(150, 260, 200, 30);
        velocidadNadoField.setBounds(150, 300, 200, 30);
        duracionBuceoField.setBounds(150, 340, 200, 30);
        guardarButton.setBounds(150, 380, 200, 30);

        add(new JLabel("Nombre Científico:")).setBounds(20, 20, 120, 30);
        add(new JLabel("Esperanza de Vida:")).setBounds(20, 60, 120, 30);
        add(new JLabel("Temperatura Corporal:")).setBounds(20, 100, 120, 30);
        add(new JLabel("Cantidad de Huevos:")).setBounds(20, 140, 120, 30);
        add(new JLabel("Longitud:")).setBounds(20, 180, 120, 30);
        add(new JLabel("Especie:")).setBounds(20, 220, 120, 30);
        add(tipoAguaCheckBox);
        add(new JLabel("Velocidad de Nado:")).setBounds(20, 300, 120, 30);
        add(new JLabel("Duración de Buceo:")).setBounds(20, 340, 120, 30);
        add(nombreCientificoField);
        add(esperanzaVidaField);
        add(temperaturaCorporalField);
        add(cantidadHuevosField);
        add(longitudField);
        add(especieField);
        add(velocidadNadoField);
        add(duracionBuceoField);
        add(guardarButton);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double longitud = Double.parseDouble(longitudField.getText());
                String especie = especieField.getText();
                boolean tipoAgua = tipoAguaCheckBox.isSelected();
                int velocidadNado = Integer.parseInt(velocidadNadoField.getText());
                int duracionBuceo = Integer.parseInt(duracionBuceoField.getText());

                ReptilesAcuaticos reptilAcuatico = new ReptilesAcuaticos(
                        nombreCientificoField.getText(),
                        Integer.parseInt(esperanzaVidaField.getText()),
                        Integer.parseInt(temperaturaCorporalField.getText()),
                        Integer.parseInt(cantidadHuevosField.getText()),
                        longitud, especie, tipoAgua, velocidadNado, duracionBuceo);

                // Aquí puedes llamar a la lógica de guardar en CSV
                // Ejemplo: leerCSV.GuardarReptilesAcuaticos(reptilAcuatico);
                JOptionPane.showMessageDialog(null, "Reptil acuático guardado.");
            }
        });

        setVisible(true);
    }
}
