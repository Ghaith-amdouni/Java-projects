
import javax.swing.*;
import java.awt.*;//for the layoutmanager

public class Calculatrice extends JFrame {
    private JTextField ecran;

    public Calculatrice() {
        setTitle("Calculatrice");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        ecran = new JTextField("0");
        ecran.setHorizontalAlignment(JTextField.RIGHT);
        ecran.setFont(new Font("Arial", Font.BOLD, 24));
        ecran.setEditable(false);
        add(ecran, BorderLayout.NORTH);

        JPanel panelBoutons = new JPanel(new GridLayout(5, 4, 10, 10));
        panelBoutons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] boutons = {
                "C", "±", "%", "÷",
                "7", "8", "9", "×",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ".", "", "="
        };
//no need for the adapter bcz the actionlistener has only the  actionperformed method
        ButtonListener listener = new ButtonListener(ecran);

        for (String texte : boutons) {
            if (!texte.isEmpty()) {
                JButton btn = new JButton(texte);
                btn.setFont(new Font("Arial", Font.BOLD, 18));
                btn.setPreferredSize(new Dimension(80, 60));
                btn.addActionListener(listener);
                panelBoutons.add(btn);
            } else {
                panelBoutons.add(new JPanel());
            }
        }

        add(panelBoutons, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculatrice().setVisible(true));
    }
}
