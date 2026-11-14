import juego.GestorJuego;
import personajes.*;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final GestorJuego gestorJ = new GestorJuego();

    public static void main(String[] args) {

        do{
            mostrarMenu();
            int opcion = pedirEntero("Seleccione una opcion: ",1);
            if(opcion > 11){
                System.out.println("El valor ingresado no es válido");
                continue;
            }
            if(opcion == 11){
                System.out.println("Gracias por utilizar le sistema ESFOT RPG - JAVA POO ");
                System.out.println("Saliendo...............................");
                break;}

            switch (opcion){
                case 1: crearGuerrero(); break;
                case 2: crearMago(); break;
                case 3: crearArquero(); break;
                case 4: crearPaladin(); break;
                case 5: gestorJ.mostrarTodos(); break;
                case 6: buscarPersonaje(); break;
                case 7: atacarPersonaje(); break;
                case 8: usarHabilidad(); break;
                case 9: simularCombate(); break;
                case 10: gestorJ.mostrarVivos(); break;
                default:
                    System.out.println("Ingrese la opción nuevamente"); break;
            }
        }while(true);
    }
    public static void mostrarMenu(){
        System.out.println("\n=======================================================");
        System.out.println("               ESFOT RPG - JAVA POO                      ");
        System.out.println("=========================================================");
        System.out.println("1. Crear Guerrero");
        System.out.println("2. Crear Mago");
        System.out.println("3. Crear Arquero");
        System.out.println("4. Crear Paladín");
        System.out.println("5. Mostrar personajes");
        System.out.println("6. Buscar personaje por nombre");
        System.out.println("7. Atacar a otro personaje");
        System.out.println("8. Utilizar habilidad especial");
        System.out.println("9. Simular combate por turnos");
        System.out.println("10. Mostrar personajes vivos");
        System.out.println("11. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    public static String pedirNombre(){
        while(true){
            System.out.print("Ingrese el nombre: ");
            String nombre = sc.nextLine();
            if(!nombre.isEmpty()){
                return nombre;
            }else{
                System.out.println("El campo nombre no puede estar vacio");}
        }
    }
    public static int pedirEntero(String mensaje, int m){
        while(true){
            System.out.print(mensaje);
            if(!sc.hasNextInt()){
                System.out.println("El valor ingresado no es válido");
                sc.nextLine();
                continue;
            }
            int valor = sc.nextInt();
            sc.nextLine();
            if(valor<m){
                System.out.println("El valor ingresado debe ser mayor o igual a "+m);
                continue;
            }
            return valor;
        }
    }
    private static Personaje pedirPersonaje(String mensaje){
        System.out.println(mensaje);
        return gestorJ.buscarPorNombre(sc.nextLine().trim());
    }

    private static void crearGuerrero(){
        System.out.println("-----------------------Crear un Guerrero---------------------");
        String nombre = pedirNombre();
        int nivel = pedirEntero("Nivel:", 1);
        int vidaMaxima = pedirEntero("Vida Maxima:", 1);
        int ataque = pedirEntero("Ataque:", 0);
        int defensa = pedirEntero("Defensa:", 0);
        int fuerza = pedirEntero("Fuerza:",0);
        gestorJ.agregarPersonaje(
                new Guerrero(nombre,nivel,vidaMaxima,ataque,defensa,fuerza)
        );
    }
    private static void crearMago(){
        System.out.println("----------------------Crear un Mago--------------------------");
        String nombre = pedirNombre();
        int nivel = pedirEntero("Nivel: ", 1);
        int vidaMaxima = pedirEntero("Vida Maxima: ", 1);
        int ataque = pedirEntero("Ataque: ", 0);
        int defensa = pedirEntero("Defensa: ", 0);
        int mana = pedirEntero("Mana: ",0);
        gestorJ.agregarPersonaje(
                new Mago(nombre,nivel,vidaMaxima,ataque,defensa,mana)
        );
    }
    private static void crearArquero(){
        System.out.println("----------------------Crear un Arquero-----------------------");
        String nombre = pedirNombre();
        int nivel = pedirEntero("Nivel: ", 1);
        int vidaMaxima = pedirEntero("Vida Maxima: ",1);
        int ataque = pedirEntero("Ataque: ",0);
        int defensa = pedirEntero("Defensa: ",0);
        int flechas = pedirEntero("Flechas: ",0);
        gestorJ.agregarPersonaje(
                new Arquero(nombre,nivel,vidaMaxima,ataque,defensa,flechas)
        );
    }
    private static void crearPaladin(){
        System.out.println("----------------------Crear un Paladin-----------------------");
        String nombre = pedirNombre();
        int nivel = pedirEntero("Nivel: ", 1);
        int vidaMaxima = pedirEntero("Vida Maxima: ",1);
        int ataque = pedirEntero("Ataque: ",0);
        int defensa = pedirEntero("Defensa: ",0);
        int fuerza = pedirEntero("Fuerza: ",0);
        int energiaSagrada = pedirEntero("Energia sagrada: ",0);
        gestorJ.agregarPersonaje(
                new Paladin(nombre,nivel,vidaMaxima,ataque,defensa,fuerza,energiaSagrada)
        );
    }
    private static void buscarPersonaje(){
        System.out.println("----------------------Buscar personaje por nombre-----------------------");
        Personaje p = pedirPersonaje("Ingrese el nombre del Personaje: ");
        if(p == null){
            System.out.println("No se encontro algún personaje con ese nombre");
            return;
        }
        p.mostrarInformacion();
    }
    private static void atacarPersonaje(){
        Personaje enemigo = pedirPersonaje("Ingrese el nombre del enemigo: ");
        if (enemigo == null){
            System.out.println("El enemigo no fue encontrado");
            return;
        }
        Personaje objetivo = pedirPersonaje("Ingrese el nombre del objetivo: ");
        if (objetivo == null){
            System.out.println("El objetivo no fue encontrado");
            return;
        }
        realizarAtaque(enemigo, objetivo);
    }
    private static void realizarAtaque(Personaje enemigo, Personaje objetivo){
        System.out.println("¿Desea ingresar una bonificación? (s/n): ");
        String respuesta = sc.nextLine().trim();
        if(respuesta.equalsIgnoreCase("s")){
            int bonificacion = pedirEntero("Bonificación: ",0);
            enemigo.atacar(objetivo, bonificacion);
        }else{enemigo.atacar(objetivo);}
        System.out.println("Vida "+objetivo.getNombre()+": "+objetivo.getVida());
    }
    private static void usarHabilidad(){
        Personaje p = pedirPersonaje("Ingrese el nombre del Personaje: ");
        if(p == null){
            System.out.println("El peronaje no fue encontrado");
            return;
        }
        if(p instanceof Arquero){
            habilidadArquero((Arquero) p);
        }else if (p instanceof Guerrero){
            habilidadGuerrero((Guerrero) p);
        }else if (p instanceof Mago){
            habilidadMago((Mago) p);
        } else if (p instanceof Paladin) {
            habilidadPaladin((Paladin) p);
        }else{
            System.out.println("El personaje no posee habilidades especiales");
        }
    }

    private static void habilidadArquero(Arquero arquero){
        Personaje a = pedirPersonaje("Ingrese el nombre del personaje: ");
        if(a == null){
            System.out.println("El personaje no fue encontrado");
            return;
        }
        arquero.dispararFlecha(a);
    }
    private static void habilidadGuerrero( Guerrero guerrero){
        Personaje g = pedirPersonaje("Ingrese el nombre del personaje: ");
        if(g == null){
            System.out.println("El personaje no fue encontrado");
            return;
        }
        guerrero.atacar(g);
    }
    private static void habilidadMago(Mago mago){
        Personaje m = pedirPersonaje("Ingrese el nombre del personaje: ");
        if(m == null){
            System.out.println("El personaje no fue encontrado");
            return;
        }
        mago.lanzarHechizo(m);
    }
    private static void habilidadPaladin(Paladin paladin){
        System.out.println("1) Curar \n2. Activar escudo");
        int op = pedirEntero("Ingrese una opción: ",1);
        if(op == 1){
            Personaje pld = pedirPersonaje("Ingrese el nombre del personaje: ");
            if(pld == null){
                System.out.println("El personaje no fue encontrado");
                return;
            }
            paladin.curar(pld);
        }else if(op == 2){
            paladin.activarEscudo();
        }else{System.out.println("Opción inválida");}
    }
    private static void simularCombate(){
        if(gestorJ.getPersonajes().size() < 2){
            System.out.println("Se necesita al menos 2 personajes registrados");
            return;
        }
        Personaje a =pedirPersonaje("Nombre del primer combatiente: ");
        if(a == null){
            System.out.println("Personaje no fue encontrado");
            return;
        }
        Personaje b = pedirPersonaje("Nombre del segundo combatiente: ");
        if(b == null){
            System.out.println("Personaje no fue encontrado");
            return;
        }
        if(a == b){
            System.out.println("No puedes combatir contra el mismo personaje");
            return;
        }
        gestorJ.combate(a,b);
    }
}