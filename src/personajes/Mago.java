package personajes;

public class Mago extends Personaje{
    private int mana;

    public Mago() {}
    public Mago(String nombre, int nivel, int vida, int vidaMaxima, int ataque, int defensa) {
        super(nombre, nivel, vida, vidaMaxima, ataque, defensa);
    }

    public int getMana() {return mana;}
    public void setMana(int mana) {
        if(mana < 0){
            System.out.println("El mana no puede ser negativo");
        }else{this.mana = mana;}
    }

    public void lanzarHechizo(Personaje enemigo){
        if(!estaVivo()){
            System.out.println("El personaje "+getNombre()+" fué derrotado y no podrá lanzar más hechizos");
            return;
        }
        if(mana < 10){
            System.out.println("El personaje "+getNombre()+" no posee mná suficiente");
            return;
        }
        if(enemigo == null || !enemigo.estaVivo()){
            System.out.println("El enemigo fué derrotado o no se encuentra registrado");
            return;
        }
        mana -=10;
        System.out.println("El "+getNombre()+" lanza un hechizo a"+enemigo.getNombre());
        enemigo.recibirDanio(20);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("----------------------------- Mago ----------------------------------------");
        super.mostrarInformacion();
        System.out.println("Mana: "+mana);
        System.out.println("---------------------------------------------------------------------------");
    }
}
