import java.util.ArrayList;

public class Exercito {

    public ArrayList<Personagem> personagens;

    public Exercito() {
        personagens = new ArrayList<Personagem>();
    }

    public void recrutarPersonagem(Personagem personagem){
        personagens.add(personagem);
    }

    public Personagem getPersonagem(int pos) {
        try {
            return personagens.get(pos);
        }
        catch(Exception e) {
            return null;
        }
    }

    public void mostrarExercito() {
        int soldadoMorto = -1;
        for (int pos = 0; pos < personagens.size(); pos++)
            if (personagens.get(pos).estaMorto())
                soldadoMorto = pos;
        if (soldadoMorto != -1)
            personagens.remove(soldadoMorto);
    }

    public boolean foiDerrotado() {
        return personagens.size() == 0;
    }

}
