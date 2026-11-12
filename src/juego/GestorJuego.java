package juego;

import personajes.Personaje;

import java.util.*;

public class GestorJuego {

    private List<Personaje> personajes;
    private Map<String, Personaje> registro;

    public GestorJuego(){
        this.personajes = new ArrayList<>();
        this.registro = new HashMap<>();
    }
    public List<Personaje> getPersonajes(){ return this.personajes; }
    public Map<String, Personaje> getRegistro(){ return this.registro; }

    public boolean existeNombre(String nombre){
        return nombre != null && registro.containsKey(nombre.toUpperCase());
    }

    public boolean agregarPersonaje(Personaje p){
        if(p == null){return false;}
        if(existeNombre(p.getNombre())){
            System.out.println("Ya existe registrado un personaje con ese nombre"+p.getNombre());
            return false;}
        personajes.add(p);
        registro.put(p.getNombre().toLowerCase(), p);
        System.out.println("El personaje "+p.getNombre()+" se ha agregado correctamente");
        return true;
    }

    public Personaje buscarPorNombre(String nombre){
        return null;
    }

    public void mostrarTodos(){}

    public void mostrarVivos(){}

    public void combate(){}

}
