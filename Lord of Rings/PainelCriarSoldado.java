import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelCriarSoldado extends JPanel {

    private JTextField jtNome;
    private JComboBox<String> jcTipo;
    private JTextField jtVida;
    private JTextField jtArmadura;
    private JButton btAdicionar;
    private Exercito exercito;
    private PainelLista lista;

    public PainelCriarSoldado(String titulo, String[] tipos, Exercito exercito) {
        jtNome = new JTextField();
        jcTipo = new JComboBox<String>(tipos);
        jtVida = new JTextField();
        jtArmadura = new JTextField();
        btAdicionar = new JButton("Adicionar");
        btAdicionar.addActionListener(new AcaoCriarSoldado());
        this.exercito = exercito;

        lista = new PainelLista(titulo, exercito);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new PainelLabel("Nome:", jtNome));
        add(new PainelLabel("Tipo:", jcTipo));
        add(new PainelLabel("Vida:", jtVida));
        add(new PainelLabel("Armadura:", jtArmadura));

        JPanel pnAdicionar = new JPanel();
        pnAdicionar.add(btAdicionar);
        add(pnAdicionar);

        add(lista);

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15),
                BorderFactory.createTitledBorder(titulo)));
    }

    private class PainelLabel extends JPanel {

        public PainelLabel(String texto, JComponent componente) {
            setLayout(new GridLayout(1,2));
            add(new JLabel(texto));
            add(componente);
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        }
    }

    private class AcaoCriarSoldado implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = jtNome.getText();
            String tipo = (String) jcTipo.getSelectedItem();
            int vida = Integer.parseInt(jtVida.getText());
            int armadura = Integer.parseInt(jtArmadura.getText());

            switch (tipo) {
                case "Elfo":
                    exercito.recrutarPersonagem(new Elfo(nome, vida, armadura));
                    break;
                case "Humano":
                    exercito.recrutarPersonagem(new Humano(nome, vida, armadura));
                    break;
                case "Hobbit":
                    exercito.recrutarPersonagem(new Hobbit(nome, vida, armadura));
                    break;
                case "Anões":
                    exercito.recrutarPersonagem((new Anões(nome, vida, armadura)));
                    break;
                case "Troll":
                    exercito.recrutarPersonagem(new Trolls(nome, vida, armadura));
                    break;
                case "Orc":
                    exercito.recrutarPersonagem(new Orcs(nome, vida, armadura));
                    break;
            }
            jtNome.setText(null);
            jcTipo.setSelectedIndex(0);
            jtVida.setText(null);
            jtArmadura.setText(null);
            lista.atualizarLista();
        }
    }
}
