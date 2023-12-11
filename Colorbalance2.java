package com.mycompany.colorbalance2;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Colorbalance2 {
    
    public static void main(String[] args) throws IOException {
        System.out.println(" red / green");
        List <String> allLines = Files.readAllLines(Paths.get("Sequences"));
 
        for (int i=0; i<maxString(allLines); i++){
            int red = 0;
            int green = 0;
            for (int j=0; j<allLines.size(); j++){
                if (i<allLines.get(j).replaceAll(" ", "").length()){
                switch (Character.toUpperCase(allLines.get(j).replaceAll(" ", "").charAt(i))) {
                    case 'T':
                        green++;
                        break;
                    case 'C':
                        red++;
                        break;
                    case 'A':
                        green++;
                        red++;
                        break;                
                    } 
                }
            }
            System.out.println(String.format("%s. %s / %s", i+1, red, green));           
        }
    }
    static private int maxString(List<String> strings){
        int maxLength = strings.get(0).replaceAll(" ", "").length();
        for (String str: strings)
            if (str.replaceAll(" ", "").length()>maxLength)
                maxLength=str.replaceAll(" ", "").length();
        return maxLength;
    }
}

