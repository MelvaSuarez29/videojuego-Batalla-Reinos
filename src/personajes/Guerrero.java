package personajes;

public class Guerrero extends Personaje {
    private int fuerza;

    public Guerrero(String nombre, int nivel, int vidaMaxima, int ataque, int defensa, int fuerza) {
        super(nombre, nivel, vidaMaxima, ataque, defensa);
        setFuerza(fuerza);
    }

    public int getFuerza() { return fuerza; }

    public void setFuerza(int fuerza) {
        if (fuerza < 0) {
            System.out.println("El valor de la fuerza debe ser mayor o igual a cero");
        } else {this.fuerza = fuerza;}
    }

    @Override
    public void atacar(Personaje enemigo) {
        super.atacar(enemigo, fuerza);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("---------------------------- Guerrero -------------------------------------");
        super.mostrarInformacion();
        System.out.println("Fuerza: " + fuerza);
        System.out.println("---------------------------------------------------------------------------");
    }
}