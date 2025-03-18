import java.util.Random;

public class Herois extends Personagem {

    public Herois(String nome, int pontosVida, int nivelResistenciaArmadura) {
        super(nome, pontosVida, nivelResistenciaArmadura);
    }

    @Override
    public String atacar(Personagem inimigo) {
        Random dados = new Random();
        int dado1 = dados.nextInt(101);
        int dado2 = dados.nextInt(101);
        int maximo = Math.max(dado1, dado2);
        inimigo.receberAtaque(maximo);
        return "Primeiro dado: " + dado1 + "\n" + "Segundo dado: " + dado2;
    }
}
