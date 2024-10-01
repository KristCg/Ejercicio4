import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

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

        // Añadir componentes al panel
        panel.add(nombreCientificoLabel);
        panel.add(nombreCientificoField);

        panel.add(longitudLabel);
        panel.add(longitudField);

        panel.add(colorPielLabel);
        panel.add(colorPielField);

        panel.add(esVenenosaLabel);
        panel.add(esVenenosaCheckBox);

        panel.add(new JLabel()); // Espacio vacío para alinear el botón
        panel.add(guardarButton);

        add(panel);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarSerpiente();
            }
        });
    }

}