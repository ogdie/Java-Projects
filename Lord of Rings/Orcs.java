import java.util.Random;

public class Orcs extends Bestas {

    public Orcs(String nome, int pontosVida, int nivelResistenciaArmadura) {
        super(nome, pontosVida, nivelResistenciaArmadura);
    }

    @Override
    public String atacar(Personagem inimigo) {
        if (inimigo instanceof Herois) {
            Random dados = new Random();
            int dadoOrc = dados.nextInt(91);
            int maximo = dadoOrc;
            int armaduraOriginal = inimigo.getNivelResistenciaArmadura();
            double atkEspecial = (inimigo.getNivelResistenciaArmadura() * 0.1);
            double armaduraPartida = inimigo.getNivelResistenciaArmadura() - atkEspecial;
            inimigo.setNivelResistenciaArmadura((int) armaduraPartida);
            inimigo.receberAtaque(maximo);
            inimigo.setNivelResistenciaArmadura(armaduraOriginal);
            return "Valor do dado: " + dadoOrc + "\n" + "***!! O Orc é tem uma força descomunal e seus adversários perdem 10% do escudo!!***\n"
                    + "Valor de ataque resultante: " + maximo;

        }
        else
            return super.atacar(inimigo);
    }
}
