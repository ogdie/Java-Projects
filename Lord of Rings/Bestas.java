import java.util.Random;

public class Bestas extends Personagem {


    public Bestas(String nome, int pontosVida, int nivelResistenciaArmadura) {
        super(nome, pontosVida, nivelResistenciaArmadura);
    }

    @Override
    public String atacar(Personagem inimigo) {
        Random dados = new Random();
        int dado1 = dados.nextInt(91);
        inimigo.receberAtaque(dado1);
        return "Resultado do dado é: " + dado1;
    }
}
