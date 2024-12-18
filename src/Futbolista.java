import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Futbolista extends Thread {

    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;
    private final Random random;

    public Futbolista(String name) {
        super(name);
        this.ngols = 0;
        this.ntirades = 0;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if (random.nextFloat() < PROBABILITAT) {
                ngols++;
            }
        }
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    public static void main(String[] args) {
        String[] nomsJugadors = {"Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"};
        List<Futbolista> futbolistes = new ArrayList<>();

        // Creació dels fils
        for (String nom : nomsJugadors) {
            futbolistes.add(new Futbolista(nom));
        }

        System.out.println("Inici dels xuts --------------------");

        // Inici dels fils
        for (Futbolista futbolista : futbolistes) {
            futbolista.start();
        }

        // Espera a que tots els fils acabin
        for (Futbolista futbolista : futbolistes) {
            try {
                futbolista.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fi dels xuts -----------------------");

        // Mostra les estadístiques
        System.out.println("--- Estadístiques ------");
        for (Futbolista futbolista : futbolistes) {
            System.out.println(futbolista.getName() + " -> " + futbolista.getNgols() + " gols");
        }
    }
}
