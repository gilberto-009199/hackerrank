package algoritm

import java.io.*;
import java.util.*;


// https://www.hackerrank.com/challenges/java-loops/problem

public class SequenceProgressionGeometric {


    public static int calcularSequencia(int coeficiente, int i) {
        return coeficiente * (int) (Math.pow(2, i + 1) - 1);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numLinhas = scanner.nextInt();
        
        // Processamento de cada linha
        for (int linha = 0; linha < numLinhas; linha++) {
            int comp = scanner.nextInt();
            int b = scanner.nextInt();
            int numInteracoes = scanner.nextInt();
            

            for (int j = 0; j < numInteracoes; j++) {
                System.out.print(comp + calcularSequencia(b, j)+" ");
            }
            System.out.println("");
        }
        
        scanner.close();
    }
}
