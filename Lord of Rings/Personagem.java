public abstract class Personagem {

    private String nome;
    private int pontosVida;
    private int nivelResistenciaArmadura;

    public Personagem(String nome, int pontosVida, int nivelResistenciaArmadura) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.nivelResistenciaArmadura = nivelResistenciaArmadura;
    }

    public String getNome() {
        return nome;
    }

    public boolean estaMorto() {
        return pontosVida <= 0;
    }

    public int getNivelResistenciaArmadura() {
        return nivelResistenciaArmadura;
    }

    public void setNivelResistenciaArmadura(int nivelResistenciaArmadura) {
        this.nivelResistenciaArmadura = nivelResistenciaArmadura;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public int setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
        return pontosVida;
    }

    public void recuperarHP() {
        pontosVida += 10;
    }
    public void receberAtaque(int ataque) {
        if (ataque > nivelResistenciaArmadura)
            pontosVida -= ataque - nivelResistenciaArmadura;

        if (pontosVida < 0)
            pontosVida = 0;
    }

    @Override
    public String toString() {
        return String.format("%s (Vida=%d Armadura=%d)", nome, pontosVida,
                nivelResistenciaArmadura);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Personagem) {
            Personagem outroPersonagem = (Personagem) obj;
            return nome.equals(outroPersonagem.getNome());
        } else
            return false;
    }

    public abstract String atacar(Personagem inimigo);
}

