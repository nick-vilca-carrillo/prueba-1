
    
/*Proyecto: videojuego
  Descripcion: Este vidojuego consta de un laberinto en el cual la salida se encuentra oculta y debes encontrar las llaves requeridas para poder salir, cuenta con trampas 
  dispersas las cuales debes responder para avanzar.
  Autor: nick erick vilca carrillo
 */


import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
public class videojuego {

    int pruebaRama =0;
    
//CREACION DE LAS MATRICES PARA LOS LABERINTOS
    private static int[][] lab = {
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
    {1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1},
    {1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1},
    {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1},
    {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
    {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
    {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
    {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
    {1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
    {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1},
    {1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
    {1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    private static int[][] lab1 = {     
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
   
};
    
//DECLARACION DE VARIABLES A UTILIZAR
    private static int posX = 1;
    private static int posY = 1;
    private static int preguntasRespondidas = 0;
    private static int fallos = 0;
    private static int partidasFacil = 0;
    private static int partidaDificil =0;
    private static int preguntasTotal =0;
    private static int fallosTotal = 0;
    private static int victoriaFacil = 0;
    private static int victoriaDificil=0;
    
    //CREAMOS UN METODO QUE RECIBE 2 PARAMETROS PARA CREAR LAS PAREDES Y EL CAMINO DEL LABERINTO MEDIANTE BUCLES 
    private static void mostrarLaberinto(int[][] laberinto, char jugador1) {
        int filas = laberinto.length;
        int columnas = laberinto[0].length;
    
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == posY && j == posX) {
                    System.out.print(jugador1 + " "); 
                } else if (laberinto[i][j] == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    //CREAMOS UN METODO QUE RECIBE 2 PARAMETROS PARA EL MOVIMIENTO DE PERSONAJE 
    private static void moverPersonaje(char direccion, int[][] laberinto) {
        char direccion1 = Character.toLowerCase(direccion);
        switch (direccion1) {
            
            case 'w':
                if (laberinto[posY - 1][posX] == 0 || laberinto[posY - 1][posX] == 2 || laberinto[posY - 1][posX] == 3) {
                    posY--;
                }
                break;
            
            case 'a':
                if (laberinto[posY][posX - 1] == 0 || laberinto[posY][posX - 1] == 2 || laberinto[posY][posX - 1] == 3) {
                    posX--;
                }
                break;
            
            case 's':
                if (laberinto[posY + 1][posX] == 0 || laberinto[posY + 1][posX] == 2 || laberinto[posY + 1][posX] == 3) {
                    posY++;
                }
                break;
          
            case 'd':
                if (laberinto[posY][posX + 1] == 0 || laberinto[posY][posX + 1] == 2 || laberinto[posY][posX+1] == 3) {
                    posX++;
                }
                break;
            default:
                System.out.println("Dirección no válida. Usa W/A/S/D para moverte o Q para salir.");
        }
    }
   
    //DECLARACION DE VARIABLES QUE CONTIENEN LAS PREGUNTAS QUE IRAN EN LAS TRAMPAS
    private static String[][] preguntas = {
        {"¿Cuál es la capital de Francia?", "paris"},
        {"¿Cuántas letras tiene abecedario? ", "10"},
        {"Empieza por C y termina por O, está arrugado y todos lo tenemos atrás, ¿qué es?", "El codo"},
        {"Pelos por arriba y pelos por abajo, en el medio una rajita húmeda, ¿qué es?", "El ojo"},
        {"Entra duro y seco y sale blandito y mojado ¿Qué es?", "el chicle"},
        {"Tengo un par, van colgando y al caminar se van desplazando ¿Qué son?", "Los brazos"},
       
    };
    private static String[][] preguntas1 ={
        {"¿Cómo se llama el hermano mayor de Pinocho?","pinueve"},
        {"adivina la palabra: VE_GA","VENGA"},
        {"adivina la palabra: _OLLAR","COLLAR"},
        {"adivina la palabra: PE_E","PEPE"},
        {"adivina la palabra: M_ERDA","MUERDA"},
        {"adivina la palabra: ORA_","ORAR"},
        {"¿Cuántos meses tienen 28 días?","Todos"},
        {"¿Cómo se llama a un hombre que mete su instrumento en la boca de otra persona?","Dentista"},
        {"¿Qué invento te permite mirar a través de una pared?","la ventana"},
        {"¿Cuál es el animal que siempre anda con las patas en la cabeza?","el piojo"},
        {"¿Qué encontramos en medio de la nada?","ad"},
        {"¿Qué posee un cuello pero carece de cabeza?","la botella"},
        {"¿Cuántos lados tiene un triángulo?", "3"}
    };

    //ESTE METODO AGREGA LAS LLAVES DEL JUEGO EN LAS UBICACIONES COLOCADAS MEDIANTE BUCLES
    private static void agregarLlaves(int[][] laberinto, int[][] ubicaciones){
        for (int i = 0; i < ubicaciones.length; i++) {
            int fila = ubicaciones[i][0];
            int columna = ubicaciones[i][1];
            laberinto[fila][columna] = 3;
        }
    }
    private static int[][] llavesLaberinto = {
        {1,5},{5,15},{1,10}
    };
    private static int[][] llavesLaberinto1 = {
        {14,10},{1,23},{3,4},{15,24},{1,33}
    };

    
    //ESTE METODO AGREGA LAS PREGUNTAS DEL JUEGO EN LAS UBICACIONES COLOCADAS MEDIANTE BUCLES
    private static void agregarPreguntas(int[][] laberinto, int[][] ubicaciones) {
        for (int i = 0; i < ubicaciones.length; i++) {
            int fila = ubicaciones[i][0];
            int columna = ubicaciones[i][1];
            laberinto[fila][columna] = 2;
        }
    }
    private static int[][] ubicacionesLaberinto1 = {
        {1, 8}, {3, 1}, {3, 11}, {3, 8}, {4, 9}, {5, 1}, {5, 11},
        {6, 8}, {7, 13}, {8, 1}, {8, 8}, {9, 4}, {10, 5}, {11, 1}
    };

    private static int[][] ubicacionesLaberinto = {
       {3,6},{5,7},{2,10},{7,1},{9,5},{9,10}
    };

       //CREAMOS UN METODO QUE RECIBE 2 PARAMETROS QUE NOS PERMITIRA REALIZAR PREGUNTAS SI LA UBICACION DEL PERSONAJE ES IGUAL AL DE LA TRAMPA

    private static void realizarPregunta(int[][] laberinto,String[][] preguntas  ) {

        System.out.print("\033[H\033[2J");// PERMITE BORRAR EL CONTENIDO DE LA CONSOLA
        System.out.flush();

        if (laberinto[posY][posX] == 2) { 
            
            System.out.println("\nCAISTE EN UNA TRAMPA!!!! . Responde correctamente para avanzar.\n");
            int preguntaAleatoria = (int) (Math.random() * preguntas.length);
            System.out.println(preguntas[preguntaAleatoria][0]);
            
            System.out.print("\nTu respuesta: ");
            Scanner scanner = new Scanner(System.in);
            String respuesta = scanner.nextLine().trim();
    
            if (respuesta.equalsIgnoreCase(preguntas[preguntaAleatoria][1])) {
                System.out.println("\n¡RESPUESTA CORRECTA!!!! Puedes avanzar :D");
                laberinto[posY][posX] = 0; 
                preguntasRespondidas++;
                preguntasTotal++;
            } else {
                System.out.println("\nRESPUESTA INCORRECTA . Regresando al inicio del laberinto T-T");
                posX = 1;
                posY = 1;
                fallos++;
                fallosTotal++;
            }
        }
}

    // ESTE METODO CARGARA EL NIVEL QUE SE ESCOJA MEDIANTE UN SWITCH
    public static void niveles(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner scanner = new Scanner(System.in);
        System.out.println("******************************  SELECION DE DIFICULTAD  *****************************");
        System.out.println("\n\t\t\t1-Facil");
        System.out.println("\n\t\t\t2-Dificil");
        System.out.println("\n\t\t\t3-Regresar");
        System.out.print("\n\t\t\tSeleccione una opcion: ");
        int lvl= scanner.nextInt();
        
    
        switch (lvl) {
            case 1:
                partidasFacil++;
                agregarPreguntas(lab,ubicacionesLaberinto);
                agregarLlaves(lab,llavesLaberinto);          
                iniciarJuego(lab,preguntas);
                break;
            case 2:
                partidaDificil++;
                agregarPreguntas(lab1,ubicacionesLaberinto1);
                agregarLlaves(lab1,llavesLaberinto1);
                iniciarJuego(lab1, preguntas1);
                break;
            case 3:
            System.out.print("\033[H\033[2J");
            System.out.flush();
                break;
            default:
                break;
        }
    }
    // ESTE METODO CARGARA LAS INSTRUCCIONES DEL JUEGO MEDIANTE UN SWITCH
    private static void mostrarInstrucciones() {
        boolean regresar = false;
        Scanner scanner = new Scanner(System.in);

        while (!regresar) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        System.out.println("\t\t******************************  MENÚ DE INFORMACION ******************************");
       
        System.out.println("\n\t-Bienvenido a EnigMatrix, tendras que encontrar la salida la cual se encuentra oculta.");
        System.out.println("\n\t-Debes encontrar las llaves necesarias para abrir la puerta de salida. Nivel facil(3)/ Nivel dificil(5)");
        System.out.println("\n\t-Ten cuidado el camnino esta lleno de trampas");
        System.err.println("\n\t-Para salir de la trampa debes responder una pregunta (ojo que no todo es lo que parece )");
        System.out.println("\n\t-Si respondes mal seras regresado al inicio del laberitno. Buena suerte :D");
        System.out.println("\n\t5. Regresar al menú principal");
        System.out.print("\n\tSeleccione una opción: ");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 5:
                // Regresa al menú principalsd
                System.out.print("\033[H\033[2J");
                System.out.flush();
                regresar = true; 
                
                break;
            default:
            
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                break;
        }
    }
}
    // ESTE METODO CARGARA LAS ESTADISTICAS DEL JUGADOR MEDIANTE UN SWITCH
    private static void mostrarEstadisticas() {
        boolean regresar = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("******************************  ESTADISTICAS GENERALES DEL JUGADOR *****************************");
        System.out.println("\n\t\t\t-MODO FACIL: "+ partidasFacil);
        System.out.println("\n\t\t\t-VICTORIAS EN MODO FACIL: "+ victoriaFacil);
        System.out.println("\n\t\t\t-MODO DIFICIL: "+partidaDificil);
        System.out.println("\n\t\t\t-VICTORIAS EN MODO DIFICIL: "+ victoriaDificil);
        System.out.println("\n\t\t\t-PREGUNTAS RESPONDIDAS: " + preguntasTotal);
        System.out.println("\n\t\t\t-TOTAL DE FALLOS: "+ fallosTotal);
        System.out.println("\n\t\t\t5. Regresar al menú principal");
        System.out.print("\n\t\t\tSeleccione una opción: ");

        int opcion = scanner.nextInt();

        
        switch (opcion) {
            case 5:
                // Regresa al menú principal
                regresar = true; 
                System.out.print("\033[H\033[2J");
                System.out.flush();
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                break;
        }
    }

    //ESTE METODO CARGA LA MAYORIA DE FUNCIONALIDADES DEL JUEGO, LLAMA DE FORMA INTERNA A OTROS METODOS
    private static void iniciarJuego(int[][] laberinto,String[][] preguntas) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        boolean juegoActivo = true;
        Scanner scanner = new Scanner(System.in);
        long tiempoInicio = System.currentTimeMillis();// CREAMOS UNA  VARIABLE PARA MOSTRAR EL TIEMPO TRASNCURRIDO
        System.out.println("Cargando el juego...");
        System.out.print("\nID: ");
        String id = scanner.nextLine();
        char jugador = id.charAt(0);
        char jugador1 = Character.toUpperCase(jugador);
        int llave = 0;
        int llave1 = 0;
        
    
        while (juegoActivo) {
            long tiempoTranscurrido = (System.currentTimeMillis() - tiempoInicio) / 1000; // CONVERTIMOS A SEGUNDOS
            System.out.println("Tiempo transcurrido: " + tiempoTranscurrido + " segundos");

            mostrarLaberinto(laberinto, jugador1);
            
            System.out.print("\nIngresa una dirección (W/A/S/D para arriba/izquierda/abajo/derecha, Q para regresar al menu): ");
            char direccion = scanner.next().charAt(0);
            if (direccion == 'Q' || direccion == 'q') {
                System.out.print("\033[H\033[2J");
                System.out.flush();
          
            posX = 1;
            posY = 1;
            
            juegoActivo = false;
        } else {
            moverPersonaje(direccion, laberinto);
            realizarPregunta(laberinto, preguntas);
        }
    
            if (Arrays.deepEquals(laberinto, lab)){
                
                if (laberinto[posY][posX] == 3) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Llave encontrada");
                    llave++;
                    laberinto[posY][posX] = 0;
                    try {                                    //ESTE FRAGEMETO DEL CODIGO HACE UNA PAUSA DE DOS SEGUNDOS AL MOSTRAR ALGUN MENSAJE
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                }
                if ((posY == 15 && posX == 3) && llave == 0) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Encontraste la salida, pero debes encontrar todas las 3 llave para salir");

                    try {                              
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if ((posY == 15 && posX == 3) && llave == 3) {
                        ganaste(id);
                        System.out.print("tiempo: ");
                        System.out.println(tiempoTranscurrido + " segundos");
                        System.out.println("preguntas respondidas: " + preguntasRespondidas);
                        System.out.println("fallos: "+ fallos);
                        preguntasRespondidas=0;
                        fallos = 0;
                        victoriaFacil++;
                        System.out.print("\nPulsa Q para regresar al menu de inicio: ");
                        char salida = scanner.next().charAt(0);
                        char salida1 = Character.toLowerCase(salida);
                            if (salida1 == 'q') {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                juegoActivo = false;
                }
            }
            }
                // Condiciones específicas para el laberinto1
                if (Arrays.deepEquals(laberinto, lab1)) {
                    
                    if (laberinto[posY][posX] == 3) {                  
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Llave encontrada");
                    llave1++;
                    laberinto[posY][posX] = 0;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                   
                    }
                    if ((posY == 3 && posX == 29) && (llave1 >= 0 && llave1 <3)) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.print("Encontraste la salida, pero debes encontrar todas las  5 llaves para salir");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if ((posY == 3 && posX == 29) && llave1 == 5) {
                        ganaste(id);
                        System.out.print("tiempo: ");
                        System.out.println(tiempoTranscurrido + " segundos");
                        System.out.println("preguntas respondidas: " + preguntasRespondidas);
                        System.out.println("fallos: "+ fallos);
                        preguntasRespondidas=0;
                        fallos = 0;   
                        victoriaDificil++;
                        System.out.print("\nPulsa Q para regresar al menu de inicio: ");
                        char salida = scanner.next().charAt(0);
                        char salida1 = Character.toLowerCase(salida);
                        if (salida1 == 'q') {
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                        juegoActivo = false;
                    }
                    }
                }
    
          
              
        }
        posX = 1;
        posY = 1;
    }

    //ESTE METODO IMPRIME UN MENSAJE DE VICTORIA PERSONALIZADO PARA CADA JUGADOR
    private static void ganaste(String id){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\t\t\tFelicidades " + id +"!!!!! encontraste la salida ¡Ganaste!");
        
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        

        while (!salir) {
        
        System.out.println("******************************  EnigMatrix: Trampas y Respuestas  *****************************");
        System.out.println("\n\t\t\t1. Jugar");
        System.out.println("\n\t\t\t2. Descripcion del juego");
        System.out.println("\n\t\t\t3. Estadisticas");
        System.out.println("\n\t\t\t4. Salir");
        System.out.print("\n\t\t\tSeleccione una opción: ");

        int opcion = scanner.nextInt();
        
        switch (opcion) {
            case 1:
                niveles();
                break;
            case 2:
            System.out.print("\033[H\033[2J");
            System.out.flush();
                mostrarInstrucciones();
                break;
            case 3:
            System.out.print("\033[H\033[2J");
            System.out.flush();
            mostrarEstadisticas();
            break;
            case 4:
                System.out.println("¡Hasta luego!");
                salir = true;
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
               
        }      
    }
    scanner.close();
}



}
    

