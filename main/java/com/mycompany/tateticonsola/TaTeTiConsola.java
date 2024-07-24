
package com.mycompany.tateticonsola;

import java.util.Scanner;

/**
 *
 * @author Ale
 */
public class TaTeTiConsola {
    
    static char[][] tablero = new char[3][3];
    static int jugadorTurno = 1;
    static char[] simbolos =  new char[3];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        simbolos[0] = ' ';
        simbolos[1] = 'X';
        simbolos[2] = 'O';
        inicializarTablero();
        mostrarPantalla();
        jugar();
    }
    
    public static void inicializarTablero(){
        int pos = '1';
        for(int x = 0; x <3; x++){
            for(int y = 0; y < 3; y++){
            tablero[x][y] = (char) pos;
            pos++;
        } 
        }
    }
    public static void mostrarPantalla(){
        
        System.out.println(tablero[0][0] + " | " + tablero[0][1] + " | " + tablero[0][2]);
        System.out.println("---------");
        System.out.println(tablero[1][0] + " | " + tablero[1][1] + " | " + tablero[1][2]);
        System.out.println("---------");
        System.out.println(tablero[2][0] + " | " + tablero[2][1] + " | " + tablero[2][2]);
    }
    public static void jugar(){
        Scanner t = new Scanner(System.in);
        System.out.print("Jugador " + jugadorTurno + " juega con " + simbolos[jugadorTurno] + ". Indicar posicion de juego: ");
        int pos = t.nextInt();
        int x, y;
        switch(pos){
           case 1:
            x = 0;
            y = 0;
            break;
            
            case 2:
            x = 0;
            y = 1;
            break;
            
            case 3:
            x = 0;
            y = 2;
            break;
            
            case 4:
            x = 1;
            y = 0;
            break;
            
            case 5:
            x = 1;
            y = 1;
            break;
            
            case 6:
            x = 1;
            y = 2;
            break;
            
            case 7:
            x = 2;
            y = 0;
            break;
            
            case 8:
            x = 2;
            y = 1;
            break;
            
            case 9:
            x = 2;
            y = 2;
            break;
            
            default:
                System.out.println("Posicion incorrecta!!!");
                jugar();
                return;
        }
        if(tablero[x][y] == 'X' || tablero[x][y] == 'O'){
            System.out.println("Posicion ocupada, intente otra.");
            jugar();
            return;
        }
        tablero[x][y] = simbolos[jugadorTurno];
        if (!hayGanador()){
            if(jugadorTurno ==1){
                jugadorTurno++;
            }else {
                jugadorTurno--;
            }
            mostrarPantalla();
            jugar();
        }else{
            System.out.println("Ganador!!!, Desea volver a jugar? Si:1 / No:0 )");
            int continuar = t.nextInt();
            if(continuar == 1){
                inicializarTablero();
                mostrarPantalla();
                jugar();
               
            }
        }
    }
    
    public static boolean hayGanador(){
        if(tablero[0][0] ==  tablero[0][1] && tablero[0][1] == tablero[0][2]){
        //coincide primer linea
            return true;
        }else if(tablero[1][0] ==  tablero[1][1] && tablero[1][1] == tablero[1][2]){
        //coincide segunda linea
            return true;
        }else if(tablero[2][0] ==  tablero[2][1] && tablero[2][1] == tablero[2][2]){
        //coincide tercera linea
            return true;
        }else if(tablero[0][0] ==  tablero[1][0] && tablero[1][0] == tablero[2][0]){
        //coincide la primera columna
            return true;
        }else if(tablero[1][0] ==  tablero[1][1] && tablero[1][1] == tablero[1][2]){
        //coincide segunda columna
            return true;
        }else if(tablero[2][0] ==  tablero[2][1] && tablero[2][1] == tablero[2][2]){
        //coincide tercera columna
            return true;
        }else if(tablero[0][0] ==  tablero[1][1] && tablero[1][1] == tablero[2][2]){
        //coincide primer diagonal
            return true;
        }else if(tablero[2][0] ==  tablero[1][1] && tablero[1][1] == tablero[0][2]){
        //coincide segundo diagonal
            return true;
        }else{
            return false;
        }
    }
}
