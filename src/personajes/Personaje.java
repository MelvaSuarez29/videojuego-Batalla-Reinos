package personajes;

public class Personaje {
    private String nombre;
    private int nivel;
    private int vida;
    private int vidaMaxima;
    private int ataque;
    private int defensa;

    public Personaje (){}
    public Personaje(String nombre, int nivel, int vida, int vidaMaxima, int ataque, int defensa) {
        setNombre(nombre);
        setNivel(nivel);
        this.vida = vidaMaxima;
        setVidaMaxima(vidaMaxima);
        setAtaque(ataque);
        setDefensa(defensa);
    }

    public String getNombre() {  return nombre;}
    public int getNivel() { return nivel;}
    public int getVida() {  return vida;}
    public int getVidaMaxima() {   return vidaMaxima;}
    public int getAtaque() {  return ataque;}
    public int getDefensa() {  return defensa;}

    public void setNombre(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()){
            System.out.println("El nombre no puede estar vacio");
        }else{
            this.nombre = nombre.trim();}
    }

    public void setNivel(int nivel) {
        if(nivel <= 0){
            System.out.println("El nivel debe ser mayor que cero");
        }else{
        this.nivel = nivel;}
    }

    public void setVidaMaxima(int vidaMaxima) {
        if(vidaMaxima <= 0){
            System.out.println("La vida Maxima debe ser mayor que cero");
        }else {
            this.vidaMaxima = vidaMaxima;
            if (this.vida > vidaMaxima) {this.vida = vidaMaxima;}
        }
    }

    public void setVida(int vida) {
        if(vida < 0 || vida > vidaMaxima){
            System.out.println("El nivel de vida del personaje  debe estar entre cero "+ vidaMaxima);
        }else {this.vida = vida;}
    }

    public void setAtaque(int ataque) {
        if(ataque < 0){
            System.out.println("La ataque debe ser mayor que cero");
        }else{
            this.ataque = ataque;}
    }

    public void setDefensa(int defensa) {
        if (defensa < 0) {
            System.out.println("La defensa debe ser mayor que cero");
        } else {
            this.defensa = defensa;}
    }

    public boolean estaVivo(){
        return vida > 0;
    }

    public void recibirDanio(int cantidad){
        if(cantidad < 0){
            System.out.println("El nivel de daño no puede ser un valor menor a cero");
        }else{
            int danioReal = Math.max(1, cantidad - defensa);
            vida = Math.max(0, vida - danioReal);
        }
    }
    public void atacar(Personaje enemigo){
        atacar(enemigo, 0);
    }
    public void atacar(Personaje enemigo, int bonificacion){
        if(bonificacion < 0){
            System.out.println("La bonificacion es inválida"); return;
        }
        if (!estaVivo()) {
            System.out.println("El "+nombre+" fue derrotado, no puede atacar"); return;
        }
        if(enemigo == null || !enemigo.estaVivo()){
            System.out.println("El enemigo fue derrotado o no es válido"); return;
        }
        enemigo.recibirDanio(ataque+ bonificacion);
    }

    public void mostrarInformacion(){
        System.out.println("-----------------------Información del Personaje---------------------------");
        System.out.println("Nombre: "+nombre);
        System.out.println("Nivel: "+nivel);
        System.out.println("Vida: "+vida);
        System.out.println("Vida Maxima: "+vidaMaxima);
        System.out.println("Ataque: "+ataque);
        System.out.println("Defensa: "+defensa);
        System.out.println("----------------------------------------------------------------------------");
    }

}
