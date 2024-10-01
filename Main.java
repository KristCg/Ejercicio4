import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

    String archivoCSV = "Ejercicio4\\data\\Serpientes.csv";
    LeerCSV ar = new LeerCSV(archivoCSV);

    private JTextField nombreCientificoField;
    private JTextField longitudField;
    private JTextField colorPielField;
    private JCheckBox esVenenosaCheckBox;
    private JButton guardarButton;

    private List<Serpientes> serpientes;

    public Main() {
        serpientes = new ArrayList<>();

        setTitle("Registro de Serpientes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nombreCientificoLabel = new JLabel("Nombre científico:");
        nombreCientificoField = new JTextField();

        JLabel longitudLabel = new JLabel("Longitud (metros):");
        longitudField = new JTextField();

        JLabel colorPielLabel = new JLabel("Color de piel:");
        colorPielField = new JTextField();

        JLabel esVenenosaLabel = new JLabel("¿Es venenosa?");
        esVenenosaCheckBox = new JCheckBox();

        guardarButton = new JButton("Guardar");

        panel.add(nombreCientificoLabel);
        panel.add(nombreCientificoField);

        panel.add(longitudLabel);
        panel.add(longitudField);

        panel.add(colorPielLabel);
        panel.add(colorPielField);

        panel.add(esVenenosaLabel);
        panel.add(esVenenosaCheckBox);

        panel.add(new JLabel());
        panel.add(guardarButton);

        add(panel);

        serpientes = ar.Leer();

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double longitud = Double.parseDouble(longitudField.getText());
                String especie = nombreCientificoField.getText();
                String colorPiel = colorPielField.getText();
                boolean esVenenosa = esVenenosaCheckBox.isSelected();

                Serpientes nuevaSerpiente = new Serpientes(longitud, especie, colorPiel, esVenenosa);

                serpientes.add(nuevaSerpiente);

                ar.GuardarSerpientes(serpientes);

                nombreCientificoField.setText("");
                longitudField.setText("");
                colorPielField.setText("");
                esVenenosaCheckBox.setSelected(false);

                JOptionPane.showMessageDialog(null, "Serpiente guardada correctamente.");

            }
        });
    }

    public static void main(String[] args) {
        Main ventana = new Main();
        ventana.setVisible(true);
    }
}