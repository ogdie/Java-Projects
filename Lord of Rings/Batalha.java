
public class Batalha extends Thread {

    private Exercito herois;
    private Exercito bestas;
    private PainelTexto pnTexto;


    public Batalha(Exercito herois, Exercito bestas, PainelTexto pnTexto) {
        this.herois = herois;
        this.bestas = bestas;
        this.pnTexto = pnTexto;
    }

    @Override
    public void run() {
        while(!herois.foiDerrotado() && !bestas.foiDerrotado()) {

            int turnosTotal;
            if (herois.personagens.size() >= bestas.personagens.size())
                turnosTotal = herois.personagens.size();
            else
                turnosTotal = bestas.personagens.size();

            for (int turno = 0; turno < turnosTotal; turno++) {
                Herois heroi = (Herois) herois.getPersonagem(turno);
                Bestas besta = (Bestas) bestas.getPersonagem(turno);
                if (heroi == null && besta == null)
                    break;
                else if (heroi == null) {
                    pnTexto.novaLinha(besta.getNome() + " segue aguardando.");
                    pausa(500);
                }
                else if (besta == null) {
                    pnTexto.novaLinha(heroi.getNome() + " segue aguardando.");
                    pausa(500);
                }
                else {
                    pnTexto.novaLinha("Luta entre " + heroi + " e " + besta);
                    pausa(250);
                    pnTexto.novaLinha("Turno de " + heroi.getNome());
                    pausa(250);
                    pnTexto.novaLinha(heroi.atacar(besta));
                    pnTexto.novaLinha("Dados Atualizados de " + besta);
                    pausa(1000);
                    if (besta.estaMorto()) {
                        pnTexto.novaLinha(besta.getNome() + " foi morto.");
                        pausa(1000);
                    }
                    else {
                        pnTexto.novaLinha("Turno de " + besta.getNome());
                        pausa(250);
                        pnTexto.novaLinha(besta.atacar(heroi));
                        heroi.recuperarHP();
                        pnTexto.novaLinha("Dados Atualizados de " + heroi);
                        pausa(1000);
                        if (heroi.estaMorto()) {
                            pnTexto.novaLinha(heroi.getNome() + " foi morto.");
                            pausa(1000);
                        }
                    }
                }
                herois.mostrarExercito();
                bestas.mostrarExercito();
            }
        }
        if (herois.foiDerrotado())
            pnTexto.novaLinha("As Bestas ganharam. Soldados restantes: " + bestas.personagens.size());
        else
            pnTexto.novaLinha("Os Herois ganharam. Soldados restantes: " + herois.personagens.size());
    }

    private void pausa(long milis) {
        try {
            sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
