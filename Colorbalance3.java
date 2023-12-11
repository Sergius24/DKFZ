package com.mycompany.colorbalance3;

import java.io.*;
import java.util.*;

public class Colorbalance3 {

    public static void main(String[] args) throws Exception {
        List<Cycle> cycles = new ArrayList<>();
        String line;
        int index = 0;
        try( BufferedReader bs = new BufferedReader(new FileReader("Sequences"))){    
            while ((line = bs.readLine()) != null){
                char[] sequence = line.replaceAll(" ", "").toCharArray();
                for (int i=0; i<sequence.length; i++){
                    if (cycles.size()<sequence.length){                       
                        cycles.add(new Cycle(++index));
                    }
                    switch (Character.toUpperCase(sequence[i])) {
                      case 'T':
                        cycles.get(i).setGreen(cycles.get(i).getGreen()+1);
                        break;
                      case 'C':
                        cycles.get(i).setRed(cycles.get(i).getRed()+1);
                        break;
                      case 'A':
                        cycles.get(i).setRed(cycles.get(i).getRed()+1);
                        cycles.get(i).setGreen(cycles.get(i).getGreen()+1);
                        break;
                    }                         
                }       
            }
        }
       
       System.out.println(" red / green");
       for (Cycle cl: cycles)
           System.out.println(cl);
    }
    
    static class Cycle {
       private int red;
       private int green;
       final int index;
       
       Cycle(int index){
           this.red = 0;
           this.green = 0;
           this.index = index;
       }
       
       public int getRed(){
        return red;   
       }
       public void setRed(int red)
       {
           this.red = red;
       }
       
       public int getGreen(){
        return green;   
       }
       public void setGreen(int green)
       {
           this.green = green;
       }
       
       @Override
       public String toString(){
           return String.format("%s. %s / %s", index, red, green);
       }
    }
}

