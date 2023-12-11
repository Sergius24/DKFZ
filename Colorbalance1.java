package com.mycompany.colorbalance1;

import java.util.*;

public class Colorbalance1 {
    
    public static void main(String[] args) {
        if (args.length!=0){
            System.out.println(" red / green");
            List <int[]> cycles = new ArrayList<>();
            for (String str: args){
                for (int i=0; i<str.length(); i++){
                    if (cycles.size()<str.length())
                            cycles.add(new int[] {0,0});
                    switch (Character.toUpperCase(str.charAt(i))){
                        case 'T':
                        cycles.get(i)[1]++;
                        break;
                        case 'C':
                        cycles.get(i)[0]++;
                        break;
                        case 'A':
                        cycles.get(i)[0]++;
                        cycles.get(i)[1]++;
                        break;                       
                    }                   
                }
            }
            for (int j = 0; j<cycles.size(); j++){
               System.out.println(String.format("%s. %s / %s", j+1, cycles.get(j)[0], cycles.get(j)[1]));
            } 
        }      
    }                      
}

