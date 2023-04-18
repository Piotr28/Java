/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author st508
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a,b,c,d = 0;
        
        System.out.println("Podaj liczbę 1");
        a = scanner.nextInt();
        System.out.println("Podaj liczbę 2");
        b = scanner.nextInt();
        System.out.println("Podaj działanie\n1-Suma \n2-Odejmowanie\n3-Mnozenie\n4-dzielenie");
        c = scanner.nextInt();
        switch (c) {
            case 1:
                d = a + b;
                break;
            case 2:
                d = a - b;
                break;
            case 3:
                d = a * b;
                break;
            case 4:
                d = a / b;
                break;
            default:
                break;
        }
        System.out.println("Wynik = " + d);
    }
    
}
