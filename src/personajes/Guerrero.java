package personajes;

public class Guerrero extends Personaje{
    private int fuerza;

    public Guerrero() {}
    public Guerrero(String nombre, int nivel, int vida, int vidaMaxima, int ataque, int defensa) {
        super(nombre, nivel, vida, vidaMaxima, ataque, defensa);
    }
    public int getFuerza() { return fuerza; }
    public void setFuerza(int fuerza) {
        if(fuerza < 0){
            System.out.println("EL valor de la fuerza debe cer mayor a cero");
        }else{this.fuerza = fuerza;}
    }

    @Override
    public void atacar(Personaje enemigo) {
        super.atacar(enemigo);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("---------------------------- Guerrero -------------------------------------");
        super.mostrarInformacion();
        System.out.println("Fuerza: "+fuerza);
        System.out.println("---------------------------------------------------------------------------");
    }
}
