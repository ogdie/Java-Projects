import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PainelTexto extends JPanel {

    private JTextArea areaTexto;
    private JButton btLutar;
    private JScrollPane scrollArea;

    public PainelTexto() {
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        btLutar = new JButton("Lutar!");

        scrollArea = new JScrollPane();
        scrollArea.setViewportView(areaTexto);
        scrollArea.setPreferredSize(new Dimension(50, 200));
        scrollArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 20, 20, 20),
                BorderFactory.createLoweredSoftBevelBorder()));

        JPanel pnBotao = new JPanel();
        pnBotao.add(btLutar);

        setLayout(new BorderLayout());
        add(pnBotao, BorderLayout.NORTH);
        add(scrollArea, BorderLayout.CENTER);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 10, 10, 10),
                BorderFactory.createRaisedSoftBevelBorder()));
    }

    public void setAcaoBotaoLutar(ActionListener acao) {
        btLutar.addActionListener(acao);
    }

    public void novaLinha(String linha) {
        areaTexto.append(linha + "\n");
        Dimension dim = areaTexto.getSize();
        Point p = new Point(0, dim.height);
        scrollArea.getViewport().setViewPosition(p);
    }
}
