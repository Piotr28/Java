/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Scanner;

/**
 *
 * @author st508
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        //Zad.1
        
        System.out.print("Podaj tekst\n");
        Scanner scanner = new Scanner(System.in);
        String wej = scanner.nextLine();
        char[] litery = wej.toCharArray();
        char litera = litery[(wej.length()-1)];
        int licz=0;
        for(char kolejna : litery){
            if(litera == kolejna){
                licz++;
            }
        }
        System.out.print("Podany tekst zawiera " + licz + " ostatnich liter\n");
        
        //Zad.2
        System.out.print("Podaj tekst\n");
        Scanner scanner = new Scanner(System.in);
        String wej = scanner.nextLine();
        String wyj = "";
        for(int x=(wej.length())-1;x>=0;x--){
            wyj = wyj + wej.charAt(x);
        }
        System.out.print("String od końca to: " + wyj + "\n");
        
        
        //Zad.3
        System.out.print("Podaj tekst(nie usuwa białych znaków)\n");
        Scanner scanner = new Scanner(System.in);
        String wej = scanner.nextLine();
        int a = 0, b=wej.length()-1;
        boolean test = true;
        do{
            if(wej.charAt(a)!=wej.charAt(b)){
                test = false;
                break;
            }
            a++;
            b--;
        }while(a!=b);
        if(test){
            System.out.print("Podany tekst jest palindromem\n");
        }
        else{
            System.out.print("Podany tekst nie jest palindromem\n");
        }
        */
        //Zad.4
        System.out.print("Podaj tekst\n");
        Scanner scanner = new Scanner(System.in);
        String wej = scanner.nextLine();
        int suma = 0, liczba;
        for(char kolejna : wej.toCharArray()){
            if((kolejna-48)>=0 && (kolejna-48)<=9){
                liczba = kolejna;
                suma = suma + liczba - 48;
            }
        }
        System.out.print("Suma pojedyńczych liczb to: " + suma);
    }
    
}
