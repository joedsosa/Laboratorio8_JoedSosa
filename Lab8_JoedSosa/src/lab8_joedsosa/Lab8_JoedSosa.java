/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8_joedsosa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joeds
 */
public class Lab8_JoedSosa {

    /**
     * @param args the command line arguments
     */
    static List<SuperHeroe> superHeroes = new ArrayList<>();
    static List<Pokemon> pokemones = new ArrayList<Pokemon>();
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Scanner stc = new Scanner(System.in);
        String resp = "";
        do {
            System.out.println("Bienvenido al Laboratorio #7");
            System.out.println("Hola Memo, Hola Stephanie");
            System.out.println("Sleccione el Ejericio que desea revisar: ");
            System.out.println("1) Pocket Monsters");
            System.out.println("2) DC vrs Marvel");
            int opciones = sc.nextInt();
            switch (opciones) {

                case 1:// llamar metodo
                {
                    System.out.println(" Bienvenido a el Ejercicio 1: Pocket Monsters ");
                    Ejercicio1();
                    break;
                }

                case 2: // llamar metodo
                {
                    System.out.println("Bienvenido a el Ejercicio 2: DC vrs Marvel");
                    Ejercicio2();
                    break;
                }

            }
            System.out.println("Desea continuar S para continuar, cualquier otra tecla para salir!");
            resp = stc.nextLine();
        } while ("s".equalsIgnoreCase(resp) || "S".equalsIgnoreCase(resp));

    }

    public static void Ejercicio2() {
        int opcion = 0;
        do {
            System.out.print("*** REGISTRO DE SUPER HERORES ***\n");
            System.out.println(" -------------------------------------- ");
            System.out.println("Héroes agregados para DC: " + cantidadHeroes("DC"));
            System.out.println("Héroes agregados para Marvel: " + cantidadHeroes("Marvel"));
            System.out.println(" -------------------------------------- ");
            System.out.print("1 - Agregar\n");
            System.out.print("2 - Buscar\n");
            System.out.print("3 - Salir del sistema\n");
            System.out.print("Elija Opcion: ");
            Scanner sc1 = new Scanner(System.in);
            opcion = sc1.nextInt();
            switch (opcion) {
                case 1: {
                    addHeroe();
                    break;
                }
                case 2: {
                    Scanner sc2 = new Scanner(System.in);
                    System.out.print("Ingrese el nombre:");
                    String param = sc2.nextLine();
                    buscar(param);
                    break;
                }
                case 3: {
                    System.out.println("bye.");
                    break;
                }
                default: {
                    System.out.println("Opcion incorrecta");
                }

            }
        } while (opcion != 3);
    }

    public static void buscar(String param) {
        boolean encontrado = false;
        for (SuperHeroe superHeroe : superHeroes) {
            if (param.equalsIgnoreCase(superHeroe.getNombre()) || param.equalsIgnoreCase(superHeroe.getVerdaderaIdentidad())) {
                System.out.println(" -------------------------------------- ");
                System.out.println("Nombre del super héroe: " + superHeroe.getNombre());
                System.out.println("Nombre real: " + superHeroe.getVerdaderaIdentidad());
                System.out.println("Ciudad Origen: " + superHeroe.getOrigen());
                System.out.println("Franquicia: " + superHeroe.getFranquicia());
                System.out.println(" -------------------------------------- ");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println(" -------------------------------------- ");
            System.out.println("No se ha podido encontrar el super heroe");
            System.out.println(" -------------------------------------- ");
        }
    }

    public static void addHeroe() {
        Scanner sc = new Scanner(System.in);
        SuperHeroe superH = new SuperHeroe();
        System.out.print("Ingrese el nombre del super héroe: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el nombre real: ");
        String nombreReal = sc.nextLine();
        System.out.println("Ingrese la franquicia: ");
        System.out.println("1 - DC");
        System.out.println("2 - Marvel");
        System.out.print("Elija Opcion: ");
        String franquicia = sc.nextLine();
        if ("1".equals(franquicia)) {
            franquicia = "DC";
        } else if ("2".equals(franquicia)) {
            franquicia = "Marvel";
        } else {
            System.out.println("Franqucia invalida");
            return;
        }
        if (cantidadHeroes(franquicia) < 10) {
            System.out.print("Ingrese ciudad de origen: ");
            String ciudad = sc.nextLine();
            superH.setNombre(nombre);
            superH.setVerdaderaIdentidad(nombreReal);
            superH.setFranquicia(franquicia);
            superH.setOrigen(ciudad);
            superHeroes.add(superH);
        } else {
            System.out.println("Ha llegado al numero maximo de super Heroes permitidos para agregar en una franquicia");
        }

    }

    public static int cantidadHeroes(String param) {
        int count = 0;
        for (SuperHeroe superHeroe : superHeroes) {
            if (param.equals(superHeroe.getFranquicia())) {
                count++;
            }
        }
        return count;
    }

    public static void Ejercicio1() {
        int opcion = 0;
        do {
            System.out.print("*** POCKET MONSTERS ***\n");
            System.out.println(" -------------------------------------- ");
            System.out.println("Pokemones Jugador 1: " + cantidadPokemones(1));
            System.out.println("Pokemones Jugador 2: " + cantidadPokemones(2));
            System.out.println(" -------------------------------------- ");
            System.out.print("1 - Agregar Pokemon\n");
            System.out.print("2 - Batalla Pokemon\n");
            System.out.print("3 - Salir del sistema\n");
            System.out.print("Elija Opcion: ");
            Scanner sc1 = new Scanner(System.in);
            opcion = sc1.nextInt();
            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese el numero de jugador al que agregara pokemon: ");
                    System.out.println("1 - Jugador 1");
                    System.out.println("2 - Jugador 2");
                    System.out.print("Elija Opcion: ");
                    Scanner sc = new Scanner(System.in);
                    int jugador = sc.nextInt();
                    if (jugador < 3) {
                        // ya tiene este jugador los 3 pokemones maximos
                        int cantidad = cantidadPokemones(jugador);
                        if (cantidad < 3) {
                            addPokemon(jugador);
                        } else {
                            System.out.println("Se ha superado el numero maximo de pokemones para jugador " + jugador);
                        }
                    } else {
                        System.out.println("Numero de jugador invalido");
                        return;
                    }
                    break;
                }
                case 2: {
                    if (cantidadPokemones(1) > 0 && cantidadPokemones(2) > 0) {
                        // Si cada jugador tiene al menos un pokemon para jugar
                        batallaPokemon();
                        return;
                    } else {
                        System.out.println("Debe haber al menos un pokemon por jugador");
                    }
                    break;
                }
                case 3: {
                    System.out.println("bye.");
                    break;
                }
                default: {
                    System.out.println("Opcion incorrecta");
                }

            }
        } while (opcion != 3);
    }
    public static void addPokemon(int jugador) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        Pokemon pokemon = new Pokemon();
        System.out.print("Ingrese el nombre del pokemon: ");
        String nombrePokemon=sc.nextLine();
        int puntosVida=0;
        do{
            System.out.print("Ingrese puntos de vida para * "+nombrePokemon+" * :");
            puntosVida=sc.nextInt();
            if(puntosVida>300){
              System.out.println("Debe ingresar hasta un maximo 300 puntos de vida para * "+nombrePokemon+" * ");  
            }
        } while (puntosVida>301);
        System.out.print("Ingrese puntos de ataque para * "+nombrePokemon+" * :");
        int ataque=sc.nextInt();
        pokemon.setPerteneceJugador(jugador);
        pokemon.setNombre(nombrePokemon);
        pokemon.setVida(puntosVida);
        pokemon.setAtaque(ataque);
        pokemon.setAzar(r.nextInt(5)+1);
        pokemones.add(pokemon);
    }
    
    public static int cantidadPokemones(int jugador) {
        int count=0;
        for (Pokemon pokemon : pokemones) {
            if(jugador==pokemon.getPerteneceJugador()){
                count++;
            }
        }
        return count;
    }
    
    public static int cantidadPokemonesNoEliminados(int jugador) {
        int count=0;
        for (Pokemon pokemon : pokemones) {
            if(jugador==pokemon.getPerteneceJugador() && !pokemon.isEliminado()){
                count++;
            }
        }
        return count;
    }
    
    public static void batallaPokemon() {
        // Mientras haya un pokemon por jugador
        int batallasGanadasJugador1=0;
        int batallasGanadasJugador2=0;
        int numBatallas=0;
        int pokemonesValidosP1=cantidadPokemonesNoEliminados(1);
        int pokemonesValidosP2=cantidadPokemonesNoEliminados(2);
        while (pokemonesValidosP1!=0 && pokemonesValidosP2!=0){
            int i=0;
            int postPokemon1=0;
            int postPokemon2=0;
            Pokemon pokemonJug1 = new Pokemon();
            Pokemon pokemonJug2 = new Pokemon();
            for (Pokemon pokemon : pokemones) {
                if(1==pokemon.getPerteneceJugador() && !pokemon.isEliminado()){
                    pokemonJug1=pokemon;
                    postPokemon1=i;
                }
                if(2==pokemon.getPerteneceJugador() && !pokemon.isEliminado()){
                    pokemonJug2=pokemon;
                    postPokemon2=i;
                }
                i++;
                if( pokemonJug1.getNombre()!=null && pokemonJug2.getNombre()!=null ){
                    System.out.println("----------------- Batalla "+(numBatallas+1)+"-----------------");
                    int rondas=0;
                    do{
                        System.out.println("----------------- Ronda "+(rondas+1)+"-----------------");
                        // traer pokemon para batalla
                        // Quien ataca primero 
                        int puntos1=0;
                        int puntos2=0;
                        if(pokemonJug1.getAzar()>pokemonJug2.getAzar()){
                           System.out.println(pokemonJug1.getNombre()+" ataca primero tiene: "+pokemonJug1.getVida()+" puntos de vida y "+pokemonJug1.getAzar()+" de suerte"); 
                           System.out.println(pokemonJug2.getNombre()+" ataca segundo tiene: "+pokemonJug2.getVida()+" puntos de vida y "+pokemonJug2.getAzar()+" de suerte"); 
                        }else{
                           System.out.println(pokemonJug2.getNombre()+" ataca primero tiene: "+pokemonJug2.getVida()+" puntos de vida y "+pokemonJug2.getAzar()+" de suerte"); 
                           System.out.println(pokemonJug1.getNombre()+" ataca segundo tiene: "+pokemonJug1.getVida()+" puntos de vida y "+pokemonJug1.getAzar()+" de suerte"); 
                        }
                        puntos1=pokemonJug1.getVida()-pokemonJug2.getAtaque();
                        puntos2=pokemonJug2.getVida()-pokemonJug1.getAtaque();
                        pokemonJug1.setVida(puntos1);
                        pokemonJug2.setVida(puntos2);
                        System.out.println("** Puntos Restantes **");
                        System.out.println(pokemonJug1.getNombre()+" tiene "+pokemonJug1.getVida()+" restantes ");
                        System.out.println(pokemonJug2.getNombre()+" tiene "+pokemonJug2.getVida()+" restantes ");
                        pokemones.get(postPokemon1).setVida(puntos1);
                        pokemones.get(postPokemon2).setVida(puntos2);
                        rondas++;

                        // Hasta que algun pokemon no tenga vida
                        if(pokemonJug1.getVida()<0 || pokemonJug2.getVida()<0){
                            // Ganador de esta batalla
                            if(pokemonJug1.getVida()>0){
                              System.out.println("--- Resultado ---");  
                              System.out.println(pokemonJug1.getNombre()+" es el ganador"); 
                              pokemones.get(postPokemon2).setEliminado(true);
                              batallasGanadasJugador1++;
                            }
                            if(pokemonJug2.getVida()>0){
                                System.out.println(pokemonJug2.getNombre()+" es el ganador"); 
                                pokemones.get(postPokemon1).setEliminado(true);
                                batallasGanadasJugador2++;
                            }
                        }
                        
                        // Si los dos pokemones mueren en batalla
                        if(pokemonJug1.getVida()<0 && pokemonJug2.getVida()<0){
                            System.out.println("--- Resultado ---");  
                            System.out.println("Los dos han perdido la batalla");  
                            pokemones.get(postPokemon2).setEliminado(true);
                            pokemones.get(postPokemon1).setEliminado(true);
                        }
                    } while (pokemones.get(postPokemon1).getVida()>0 && pokemones.get(postPokemon2).getVida()>0);
                    pokemonesValidosP1=cantidadPokemonesNoEliminados(1);
                    pokemonesValidosP2=cantidadPokemonesNoEliminados(2);
                    numBatallas++;
                }
                
            }
                
        }
        int ganador=(batallasGanadasJugador1>batallasGanadasJugador2)?1:2;
        System.out.println("Ganador del juego jugador :"+ganador);
    }
}
