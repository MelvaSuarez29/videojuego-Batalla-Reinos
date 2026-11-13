import juego.GestorJuego;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final GestorJuego gestorJ = new GestorJuego();

    public static void main(String[] args) {

        do{
            mostrarMenu();
            if(! sc.hasNextLine()){
                System.out.println("El valor ingresado no es válido");
                sc.nextLine();
                continue;}

            int opcion = sc.nextInt();
            sc.nextLine();

            if(opcion < 1 || opcion > 11){
                System.out.println(" El valor ingresado no es valido");
                continue;}
            if(opcion == 11){break;}

            switch (opcion){
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 6: break;
                case 7: break;
                case 8: break;
                case 9: break;
                case 10: break;
                default: break;
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
            System.out.println(mensaje);
            if(!sc.hasNextInt()){
                System.out.println("El valor ingresado no es valido");
                sc.nextLine();
                continue;
            }
            int valor = sc.nextInt();
            sc.nextLine();
            if(valor < m){
                System.out.println("El valor debe ser mayor o igual a "+m);
                continue;
            }
            return valor;
        }
    }
    private static void pedirPersonaje(String mensaje){

    }
    private static void crearGuerrero(){
        System.out.println();
    }
    private static void crearMago(){
        System.out.println();
    }
    private static void crearArquero(){
        System.out.println();
    }
    private static void crearPaladin(){

    }
    private static void buscarPersonaje(){

    }
    private static void atacarPersonaje(){

    }
    private static void realizarAtaque(){

    }
    private static void usarHabilidad(){

    }
    private static void habilidadMago(){

    }
    private static void habilidadArquero(){

    }
    private static void habilidadGuerrero(){

    }
    private static void habilidadPaladin(){

    }
    private static void simularCombate(){

    }
}