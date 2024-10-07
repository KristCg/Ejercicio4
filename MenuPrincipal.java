import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Opciones");

        JMenuItem reptilesAcuaticosMenuItem = new JMenuItem("Formulario Reptiles Acuáticos");
        JMenuItem serpientesMenuItem = new JMenuItem("Formulario Serpientes");
        JMenuItem presupuestoMenuItem = new JMenuItem("Presupuesto");
        JMenuItem administrarDatosMenuItem = new JMenuItem("Administrar Datos");

        menu.add(reptilesAcuaticosMenuItem);
        menu.add(serpientesMenuItem);
        menu.add(presupuestoMenuItem);
        menu.add(administrarDatosMenuItem);
        menuBar.add(menu);

        setJMenuBar(menuBar);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel bienvenidaLabel = new JLabel("Seleccione una opción en el boton de opciones", SwingConstants.CENTER);
        panel.add(bienvenidaLabel);

        reptilesAcuaticosMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new FormularioReptilesAcuaticos().setVisible(true);
            }
        });

        serpientesMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new FormularioSerpientes().setVisible(true);
            }
        });

        presupuestoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new MenuPresupuesto(null).setVisible(true);
            }
        });

        administrarDatosMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new VentanaReptiles().setVisible(true);
            }
        });

        add(panel);
    }

}
