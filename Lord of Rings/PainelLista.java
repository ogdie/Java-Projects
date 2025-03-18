import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelLista extends JPanel {

    private JList<Personagem> lista;
    private DefaultListModel<Personagem> modeloLista;
    private JButton btSubir;
    private JButton btBaixar;
    private JButton btEliminar;
    private Exercito exercito;

    public PainelLista(String titulo, Exercito exercito) {
        this.exercito = exercito;
        lista = new JList<Personagem>();
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modeloLista = new DefaultListModel<Personagem>();
        lista.setModel(modeloLista);
        btSubir = new JButton("Subir");
        btSubir.addActionListener(new AcaoSubirBaixar(-1));
        btBaixar = new JButton("Baixar");
        btBaixar.addActionListener(new AcaoSubirBaixar(1));
        btEliminar = new JButton("Eliminar");
        btEliminar.addActionListener(new AcaoEliminar());

        setLayout(new BorderLayout());
        JScrollPane scrollLista = new JScrollPane();
        scrollLista.setViewportView(lista);
        scrollLista.setBorder(BorderFactory.createTitledBorder(null, titulo));
        add(scrollLista, BorderLayout.CENTER);

        JPanel pnBotoes = new JPanel();
        pnBotoes.add(btSubir);
        pnBotoes.add(btBaixar);
        pnBotoes.add(btEliminar);
        add(pnBotoes, BorderLayout.SOUTH);
    }

    public void atualizarLista() {
        modeloLista.clear();
        for (Personagem sold: exercito.personagens)
            modeloLista.addElement(sold);

        lista.setModel(modeloLista);
    }

    private class AcaoEliminar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Personagem selecionado = lista.getSelectedValue();
            if (selecionado == null)
                JOptionPane.showMessageDialog(null, "Tem que selecionar um Personagem");
            else {
                exercito.personagens.remove(selecionado);
                atualizarLista();
            }
        }
    }

    private class AcaoSubirBaixar implements ActionListener {

        private int deslocamento;

        public AcaoSubirBaixar(int deslocamento) {
            this.deslocamento = deslocamento;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Personagem selecionado = lista.getSelectedValue();
            if (selecionado == null)
                JOptionPane.showMessageDialog(null, "Tem que selecionar um personagem");
            else {
                int indiceSelecionado = lista.getSelectedIndex();
                int indiceMudar = indiceSelecionado + deslocamento;
                Personagem mudar = exercito.getPersonagem(indiceMudar);

                if (mudar != null) {
                    exercito.personagens.set(indiceSelecionado, mudar);
                    exercito.personagens.set(indiceMudar, selecionado);
                    atualizarLista();
                }
            }
        }
    }
}
