/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

/**
 *
 * @author st508
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.print("Co chcesz zrobić?(Podaj nr)\n1.Stwóż karalog o podanej nazwie nazwie\n2.Stwóż plik o podanej nazwie nazwie i rozszeżeniu\n3.Usuń plik\n");
        Scanner scanner = new Scanner(System.in);
        int wyb = scanner.nextInt();
        scanner = new Scanner(System.in);
        switch (wyb){
            case 1:
                System.out.print("Podaj scieżkę do katalogu i nazwę katalogu\n");
                if(scanner.hasNext()){
                    String katalogi = scanner.nextLine();
                    Files.createDirectory(Paths.get(katalogi));
                }
            break;
            case 2:
                System.out.print("Podaj scieżkę do pliku, nazwę oraz rozszeżenie\n");
                String nazwa = scanner.nextLine();
                if(Jest(nazwa)){
                    System.out.println("Plik istniej");
                }
                else{
                    Files.createFile(Paths.get(nazwa));
                    System.out.println("Stwożnono: " + nazwa);
                }
            break;
            case 3:
                System.out.print("Podaj scieżkę do pliku, nazwę oraz rozszeżenie\n");
                String us = scanner.nextLine();
                if(Jest(us)){
                    File plik = new File(us);
                    plik.delete();
                }
                else{
                    System.out.println("Plik nie istniej");
                }
            break;
            default:
                System.out.println("Podano zły argument");
        }
    }
    
    public static boolean Jest(String nazwa){
        File plik = new File(nazwa);
        if(plik.exists()){
            return true;
        }
        else{
            return false;
        }
    }
}
