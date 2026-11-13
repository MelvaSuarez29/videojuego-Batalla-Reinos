package personajes;

public class Paladin extends Personaje {
    private int energiaSagrada;
    private boolean escudoActivo;

    public Paladin() {}

    public Paladin(String nombre, int nivel, int vida, int vidaMaxima, int ataque, int defensa) {
        super(nombre, nivel, vida, vidaMaxima, ataque, defensa);
        setEnergiaSagrada(energiaSagrada);
        this.escudoActivo = false;
    }
    public int getEnergiaSagrada() { return energiaSagrada; }
    public boolean getEscudoActivo() { return escudoActivo; }
    public void setEnergiaSagrada(int energiaSagrada) {
        if(energiaSagrada < 0){
            System.out.println("La energía sagrada no puede ser menor a cero");
        }else{this.energiaSagrada = energiaSagrada;}
    }
}
