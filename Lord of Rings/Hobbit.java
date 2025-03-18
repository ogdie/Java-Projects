import java.util.Random;

public class Hobbit extends Herois {

    public Hobbit(String nome, int pontosVida, int nivelResistenciaArmadura) {
        super(nome, pontosVida, nivelResistenciaArmadura);
    }

    @Override
    public String atacar(Personagem inimigo) {
        if (inimigo instanceof Trolls) {
            Random dados = new Random();
            int dado1 = dados.nextInt(101);
            int dado2 = dados.nextInt(101);
            int maximo = Math.max(dado1, dado2);
            maximo -= 5;
            inimigo.receberAtaque(maximo);
            return "Primeiro dado: " + dado1 + "\n" + "Segundo dado: " + dado2 + "\n"
                    + "********!! Os Hobbits tem muito medo dos trolls, perdendo 5 pontos de ataque*****\n"
                    + "Valor de ataque resultante: " + maximo;
        }
        else
            return super.atacar(inimigo);
    }

}
