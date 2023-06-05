/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.Scanner;

/**
 *
 * @author st508
 */
public class JavaApplication3 {

    private static final double pi = 3.14;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Podaj figurę do obliczenia:\n(trzeba podać nr przy figurze)\n1-koło\n2-kula\n3-stożek\n4-walec");
        Scanner scanner = new Scanner(System.in);
        int wej = scanner.nextInt();
        switch (wej){
            case 1:
                kolo pomocnicza = new kolo();
                pomocnicza.polekolo();
            break;
            case 2:
                kula pomocnicza1 = new kula();
                pomocnicza1.objkula();
            break;
            case 3:
                stozek pomocnicza2 = new stozek();
                pomocnicza2.objstozek();
            break;
            case 4:
                walec pomocnicza3 = new walec();
                pomocnicza3.objwalec();
            break;
            default:
                System.out.println("Podano zły argument");
        }
    }
    
    public static class figura{
        public double r;
        public Scanner inp = new Scanner(System.in);
        public void podanier(){
            System.out.println("Podaj r:");
            r = inp.nextDouble();
        }
    }
    public static class kolo extends figura{   
        public double pole_kolo(double y){
            return pi*(y*y);
        }
        public void polekolo(){
            podanier();
            System.out.println("Pole koła to: " +  pole_kolo(r) + "\n");
        }
    }
    public static class kula extends kolo{
        public double pole_kolo(double y){
            return pi*(y*y*y);
        }
        public void objkula(){
            podanier();
            double wynik;
            wynik = (4.0/3.0) * pole_kolo(r);
            System.out.println("Objętość kuli to: " + wynik + "\n");
        }
    }
    public static class stozek extends kolo{
        public double h;
        public void objstozek(){
            podanier();
            System.out.println("Podaj h:");
            h = inp.nextDouble();
            double wynik;
            wynik = pole_kolo(r) * (1.0/3.0) * h;
            System.out.println("Objętość stożka to: " + wynik + "\n");
        }
    }
    public static class walec extends kolo{
        public double h;
        public void objwalec(){
            podanier();
            System.out.println("Podaj h:");
            h = inp.nextDouble();
            System.out.println("Objętość walca to: " + (pole_kolo(r) * h) + "\n");
        }
    }
}
