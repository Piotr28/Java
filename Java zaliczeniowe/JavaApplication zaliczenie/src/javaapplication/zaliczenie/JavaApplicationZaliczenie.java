/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication.zaliczenie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author st508
 */
public class JavaApplicationZaliczenie {

    /**
     * @param args the command line arguments
     */
    //musi ułożyć najwyższą godzinę
    // !!!!!!!!!!!!do testu dobre: 8241
    
    
    public static void main(String[] args) {
        boolean poprawa = true;
        String wej;
        do{
            System.out.print("Podaj 4 cyfry\n(Podaj same cyfry bez znaków i nierozdielone spacją)\n");
            Scanner scanner = new Scanner(System.in);
            wej = scanner.nextLine();
            wej = wej.replaceAll("-", "");
            if(wej.length()>4 || wej.length()<4){
                System.out.println("Błędne dane\n--------------------------------------------------------------\n");
            }
            else{
                poprawa = false;
            }
        }while(poprawa);
        
        List<String> liczby = new ArrayList<>();
        for(char a: wej.toCharArray()){
            String po = "";
            po = po + a;
            liczby.add(po);
        }
        
        List<String> czasy = new ArrayList<>();
        String czas;
        int index1 = 0;
        for(String pie : liczby){
            List<String> listapomoc1 = new ArrayList<>(liczby);
            czas="";
            czas +=pie;
            String pomoc1 = czas;
            listapomoc1.remove(index1);
            int index2 = 0;
            for(String dr : listapomoc1){
                List<String> listapomoc2 = new ArrayList<>(listapomoc1);
                czas +=dr;
                String pomoc2 = czas;
                listapomoc2.remove(index2);
                int index3 = 0;
                for(String trz : listapomoc2){
                List<String> listapomoc3 = new ArrayList<>(listapomoc2);
                    czas +=trz;
                    String pomoc3 = czas;
                    listapomoc3.remove(index3);
                    for(String czt : listapomoc3){
                        czas +=czt;
                        czasy.add(czas);
                        czas = pomoc3;
                    }
                    index3++;
                    czas = pomoc2;
                }
                index2++;
                czas = pomoc1;
            }
            index1++;
        }
        
        
        int[] pos = new int[czasy.size()];
        int pomoc = 0;
        for(String linia:czasy){
            pos[pomoc] = Integer.parseInt(linia);
            pomoc++;
        }
        
        Arrays.sort(pos);
        czasy.clear();
        
        for(int x = 0; x<=23; x++){
            if(String.valueOf(pos[x]).length()== 1){
                String y ="000";
                y+= String.valueOf(pos[x]);
                czasy.add(y);
            }else if(String.valueOf(pos[x]).length()== 2){
                String y ="00";
                y+= String.valueOf(pos[x]);
                czasy.add(y);
            }else if(String.valueOf(pos[x]).length()== 3){
                String y ="0";
                y+= String.valueOf(pos[x]);
                czasy.add(y);
            }else{
                czasy.add(String.valueOf(pos[x]));
            }
        }
        
        for(int x = 0; x<czasy.size();x++){
            
            String pomocs= czasy.get(x), ostatnie = "";
            ostatnie += pomocs.charAt(2);
            ostatnie += pomocs.charAt(3);
            
            if(pos[x]>=2400 || Integer.parseInt(ostatnie)>=60){
                pos[x] = 8888;
            }
        }
                
        Arrays.sort(pos);
                
        do{
            pomoc--;
        }while(pos[pomoc]>=2400 && pomoc!=0);
        
        if(pos[pomoc] < 2400){
            String x = czasy.get(pomoc),wyjs = "";
            wyjs += x.charAt(0);
            wyjs += x.charAt(1);
            wyjs +=  ":" + x.charAt(2);
            wyjs +=  x.charAt(3);
            System.out.println("Najwyższa godzina to: " + wyjs);
        }else{
            System.out.println("Nie można ułożyć godziny");
        }
    }
    
}
