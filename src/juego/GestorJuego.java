package juego;

import personajes.Personaje;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorJuego {

    private List<Personaje> personajes;
    private Map<String, Personaje> registro;

    public GestorJuego() {
        this.personajes = new ArrayList<>();
        this.registro = new HashMap<>();
    }

    public List<Personaje> getPersonajes() { return this.personajes; }

    public Map<String, Personaje> getRegistro() { return this.registro; }

    public boolean existeNombre(String nombre) {
        return nombre != null && registro.containsKey(nombre.toLowerCase());
    }

    public boolean agregarPersonaje(Personaje p) {
        if (p == null) return false;
        if (existeNombre(p.getNombre())) {
            System.out.println("Ya existe registrado un personaje con el nombre " + p.getNombre());
            return false;
        }
        personajes.add(p);
        registro.put(p.getNombre().toLowerCase(), p);
        System.out.println("El personaje " + p.getNombre() + " se ha agregado correctamente");
        return true;
    }

    public Personaje buscarPorNombre(String nombre) {
        if (nombre == null) return null;
        return registro.get(nombre.toLowerCase());
    }

    public void mostrarTodos() {
        if (personajes.isEmpty()) {
            System.out.println("No existen personajes registrados");
            return;
        }
        System.out.println("-----------------Personajes Registrados---------------------");
        for (Personaje p : personajes) {
            p.mostrarInformacion();
            System.out.println("--------------------------------------------------------");
        }
    }

    public void mostrarVivos() {
        System.out.println("----------------------Personajes Vivos----------------------");
        boolean vivos = false;
        for (Personaje p : personajes) {
            if (p.estaVivo()) {
                p.mostrarInformacion();
                System.out.println("----------------------------------------------------");
                vivos = true;
            }
        }
        if (!vivos) {
            System.out.println("No hay personajes vivos");
        }
    }

    public void combate(Personaje a, Personaje b) {
        if (a == null || b == null || a == b) {
            System.out.println("Los personajes no son válidos para el combate");
            return;
        }
        if (!a.estaVivo() || !b.estaVivo()) {
            System.out.println("Los dos personajes deben estar vivos para combatir");
            return;
        }
        System.out.println("----------------------COMBATE----------------------");
        System.out.println(a.getNombre() + " vs " + b.getNombre());

        Personaje atacante = a;
        Personaje defensor = b;
        int turno = 1;

        while (a.estaVivo() && b.estaVivo()) {
            System.out.println("\nTurno " + turno + ": " + atacante.getNombre()
                    + " ataca a " + defensor.getNombre());
            int vidaAntes = defensor.getVida();
            atacante.atacar(defensor);
            System.out.println("Daño efectivo: " + (vidaAntes - defensor.getVida()));
            System.out.println("Vida de " + defensor.getNombre() + ": " + defensor.getVida());

            if (!defensor.estaVivo()) {
                break;
            }

            Personaje aux = atacante;
            atacante = defensor;
            defensor = aux;
            turno++;
        }

        System.out.println("GANADOR: " + (a.estaVivo() ? a.getNombre() : b.getNombre()));
    }
}