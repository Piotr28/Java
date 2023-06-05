/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.util.Scanner;

/**
 *
 * @author st508
 */
class BadTime extends Throwable{
        
    }

public class JavaApplication5 {
    
    static void printTime(int time) throws BadTime{
        if(time < 1 || time > 24){
            throw new BadTime();
        }
        System.out.println(time);
    }
    
    public static void main(String[] args) throws BadTime{
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        try{
            printTime(time);
        }catch(BadTime e){
            System.out.println("Zły czas");
            throw e;
        }
    }
    
}
