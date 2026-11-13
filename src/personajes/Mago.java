package personajes;

public class Mago extends Personaje {
    private int mana;

    public Mago(String nombre, int nivel, int vidaMaxima, int ataque, int defensa, int mana) {
        super(nombre, nivel, vidaMaxima, ataque, defensa);
        setMana(mana);
    }

    public int getMana() { return mana; }

    public void setMana(int mana) {
        if (mana < 0) {
            System.out.println("El maná no puede ser negativo");
        } else {
            this.mana = mana;
        }
    }

    public void lanzarHechizo(Personaje enemigo) {
        if (!estaVivo()) {
            System.out.println("El personaje " + getNombre() + " fue derrotado y no puede lanzar hechizos");
            return;
        }
        if (mana < 10) {
            System.out.println("El personaje " + getNombre() + " no posee maná suficiente");
            return;
        }
        if (enemigo == null || !enemigo.estaVivo()) {
            System.out.println("El enemigo fue derrotado o no se encuentra disponible");
            return;
        }
        mana -= 10;
        System.out.println("El " + getNombre() + " lanza un hechizo a " + enemigo.getNombre());
        enemigo.recibirDanio(20);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("----------------------------- Mago ----------------------------------------");
        super.mostrarInformacion();
        System.out.println("Maná: " + mana);
        System.out.println("---------------------------------------------------------------------------");
    }
}