package personajes;

public class Arquero extends Personaje {
    private int flechas;

    public Arquero(String nombre, int nivel, int vidaMaxima, int ataque, int defensa, int flechas) {
        super(nombre, nivel, vidaMaxima, ataque, defensa);
        setFlechas(flechas);
    }

    public int getFlechas() { return flechas; }

    public void setFlechas(int flechas) {
        if (flechas < 0) {
            System.out.println("La cantidad de flechas debe ser mayor o igual a cero");
        } else {
            this.flechas = flechas;
        }
    }

    public void dispararFlecha(Personaje enemigo) {
        if (!estaVivo()) {
            System.out.println("El personaje " + getNombre() + " fue derrotado y no podrá disparar");
            return;
        }
        if (flechas <= 0) {
            System.out.println("El personaje " + getNombre() + " no cuenta con flechas suficientes");
            return;
        }
        if (enemigo == null || !enemigo.estaVivo()) {
            System.out.println("El enemigo fue derrotado o no se encuentra disponible");
            return;
        }
        flechas--;
        System.out.println("El personaje " + getNombre() + " disparó una flecha a " + enemigo.getNombre());
        enemigo.recibirDanio(getAtaque() + 5);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("------------------------------------ Arquero -------------------------------");
        super.mostrarInformacion();
        System.out.println("Flechas: " + flechas);
        System.out.println("----------------------------------------------------------------------------");
    }
}