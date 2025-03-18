import java.util.Random;

public class Elfo extends Herois {

    public Elfo(String nome, int pontosVida, int nivelResistenciaArmadura) {
        super(nome, pontosVida, nivelResistenciaArmadura);
    }

    @Override
    public String atacar(Personagem inimigo) {
        if (inimigo instanceof Orcs) {
            Random dados = new Random();
            int dado1 = dados.nextInt(101);
            int dado2 = dados.nextInt(101);
            int maximo = Math.max(dado1, dado2);
            maximo += 10;
            inimigo.receberAtaque(maximo);
            return "Primeiro dado: " + dado1 + "\n" + "Segundo dado: " + dado2 + "\n"
                    + "*****O ódio élfico contra os Orcs incrementa o ataque em +10!!*****\n"
                    + "Valor de ataque resultante: " + maximo;
        }
        else
            return super.atacar(inimigo);
    }
}
