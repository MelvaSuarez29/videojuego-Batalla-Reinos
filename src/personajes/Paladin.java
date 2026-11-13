package personajes;

public class Paladin extends Guerrero {
    private int energiaSagrada;
    private boolean escudoActivo;

    public Paladin(String nombre, int nivel, int vidaMaxima, int ataque, int defensa,
                   int fuerza, int energiaSagrada) {
        super(nombre, nivel, vidaMaxima, ataque, defensa, fuerza);
        setEnergiaSagrada(energiaSagrada);
        this.escudoActivo = false;
    }

    public int getEnergiaSagrada() { return energiaSagrada; }
    public boolean getEscudoActivo() { return escudoActivo; }

    public void setEnergiaSagrada(int energiaSagrada) {
        if (energiaSagrada < 0) {
            System.out.println("La energía sagrada no puede ser menor a cero");
        } else {
            this.energiaSagrada = energiaSagrada;
        }
    }

    public void curar(Personaje objetivo) {
        if (!estaVivo()) {
            System.out.println("El personaje " + getNombre() + " fue derrotado y no puede curar");
            return;
        }
        if (energiaSagrada < 10) {
            System.out.println("El personaje " + getNombre() + " no posee energía sagrada suficiente (requiere 10)");
            return;
        }
        if (objetivo == null || !objetivo.estaVivo()) {
            System.out.println("El objetivo fue derrotado o no se encuentra disponible");
            return;
        }
        energiaSagrada -= 10;
        int vidaAntes = objetivo.getVida();
        int vidaNueva = Math.min(objetivo.getVidaMaxima(), vidaAntes + 20);
        objetivo.setVida(vidaNueva);
        System.out.println("El " + getNombre() + " cura a " + objetivo.getNombre()
                + " (+" + (vidaNueva - vidaAntes) + " vida)");
    }

    public void activarEscudo() {
        if (!estaVivo()) {
            System.out.println("El " + getNombre() + " fue derrotado y no puede activar el escudo");
            return;
        }
        this.escudoActivo = true;
        System.out.println("El " + getNombre() + " ha activado su escudo sagrado");
    }

    @Override
    public void recibirDanio(int cantidad) {
        if (cantidad < 0) {
            System.out.println("El daño no puede ser un valor negativo");
            return;
        }
        if (escudoActivo) {
            int cantidadReducida = Math.max(0, cantidad - 5);
            System.out.println("El escudo de " + getNombre() + " absorbe 5 puntos de daño");
            super.recibirDanio(cantidadReducida);
            escudoActivo = false;
        } else {super.recibirDanio(cantidad);}
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("------------------------------ Paladín ------------------------------------");
        super.mostrarInformacion();
        System.out.println("Energía sagrada: " + energiaSagrada);
        System.out.println("Escudo activo: " + (escudoActivo ? "Activo" : "Inactivo"));
        System.out.println("---------------------------------------------------------------------------");
    }
}