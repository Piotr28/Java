/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javaapplication6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author niezrozumiały
 */
public class JavaApplication6 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Co uruchomić?\n1-Licznik\n2-Szukaj");
        Scanner inpu =new Scanner(System.in);
        int uruchom = inpu.nextInt();
        switch(uruchom){
            case 1:
                System.out.println("Podaj ścieżkę do pliku txt razem z nazwą i rozszeżeniem");
                inpu =new Scanner(System.in);
                int[] wyj = new int [3];
                wyj = liczZnakiSlowa(inpu.nextLine());
                System.out.println("Liczba znaków w pliku: " + wyj[0] + "\nLiczba białych znaków: " + wyj[1]+ "\nLiczba słów(ciągu znaków oddzielonych spacją): " + wyj[2]);
            break;
            
            case 2:
                System.out.println("Podaj ścieżkę do pliku wejściowego txt razem z nazwą i rozszeżeniem");
                inpu =new Scanner(System.in);
                String i = inpu.nextLine();
                System.out.println("Podaj ścieżkę do pliku wyjściowego txt razem z nazwą i rozszeżeniem");
                inpu =new Scanner(System.in);
                String o = inpu.nextLine();
                System.out.println("Podaj wyraz do szukania");
                inpu =new Scanner(System.in);
                String s = inpu.nextLine();
                szukaj(i,o,s);
                System.out.println("Plik został zedytowany");
            break;
            
            default:
                System.out.println("Błędne dane!");
        }
    }
    
    public static int[] liczZnakiSlowa(String inp) throws FileNotFoundException, IOException{
        
        int[] wynik = new int[3];
        int liczenie = 0;
        List<String> odczyt = Files.readAllLines(Paths.get(inp));
        String caly = "";
        
        for(String linia : odczyt){
            caly = caly + linia;
        }
        wynik[0]=caly.length() + odczyt.size()-1;
        
        char[] pomoc = caly.toCharArray();
        for(int x=0; x<caly.length();x++){
            if(pomoc[x]==' ' || pomoc[x]=='\t'){
                liczenie++;
            } else {
            }
        }
        wynik[1] = liczenie + odczyt.size() - 1;
        
        Scanner scan = new Scanner(new File(inp));
        liczenie = 0;
        String pomoc2 = "";
        do{
            liczenie++;
            pomoc2 = scan.next();
        }while(scan.hasNext());
        
        wynik[2] = liczenie;
        
        return wynik;
    }
    
    public static void szukaj(String in,String out, String slowo) throws IOException{
        
        List<String> odczyt = Files.readAllLines(Paths.get(in));
        int licznik = 1;
        List<String> zapis = new ArrayList<String>();
        String caly = "";
        
        for(String linia : odczyt){
            if(linia.contains(slowo)){
                String[] pomoc1 = podzial(linia);
                for(String zdanie : pomoc1){
                    if(zdanie.contains(slowo)){
                        zapis.add(String.valueOf(licznik) + ": " + zdanie + "\n");
                    }
                }
            }
            licznik++;
        }
        
        for(String linia : zapis){
            caly = caly + linia;
        }
        
        Files.write(Paths.get(out), caly.getBytes());
    }
    
    public static String[] podzial(String in){
        
        int zliczanie = 0;
        char[] pomoc = in.toCharArray();
        for(int x=0; x<in.length(); x++){
            if(pomoc[x] == '.'){
                zliczanie++;
            }
        }
        
        String[] wyjscie = new String[zliczanie];
        
        for(int x=0; x<zliczanie; x++){
            wyjscie[x] = "";
        }
        
        int wiersz = 0;
        for(int x=0; x<in.length(); x++){
            wyjscie[wiersz] = wyjscie[wiersz] + pomoc[x];
            if(pomoc[x] == '.'){
                wiersz++;
                x++;
            }
        }
        return wyjscie;
    }
}
