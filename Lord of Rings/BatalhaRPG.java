import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BatalhaRPG extends JFrame {

    private Exercito bestas;
    private Exercito herois;

    private PainelCriarSoldado criarHerois;
    private PainelCriarSoldado criarBestas;
    private PainelTexto pnTexto;

    public BatalhaRPG() {

        bestas = new Exercito();
        herois = new Exercito();
        criarHerois = new PainelCriarSoldado("Herois", new String[] {"Elfo", "Humano", "Hobbit", "Anões"}, herois);
        criarBestas = new PainelCriarSoldado("Bestas", new String[] {"Troll", "Orc"}, bestas);

        pnTexto = new PainelTexto();
        pnTexto.setAcaoBotaoLutar(new AcaoBotaoLutar());

        JPanel pnSuperior = new JPanel();
        pnSuperior.add(criarHerois);
        pnSuperior.add(criarBestas);

        JPanel pnInferior = new JPanel();
        pnInferior.add(pnTexto);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(pnSuperior);
        add(pnTexto);

        setTitle("Batalha RPG");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class AcaoBotaoLutar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Batalha batalha = new Batalha(herois, bestas, pnTexto);
            batalha.start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BatalhaRPG();
            }
        });
    }
}
