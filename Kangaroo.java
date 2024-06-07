package algoritm;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;


import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import static java.lang.System.out;

// https://www.hackerrank.com/challenges/kangaroo/problem
public class Kangaroo {

	
	 /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Calc 
        // SE 
        //    Canguru 1 esta a frente de Canguru 2
        //   E
        //    Canguru 1 e mais rapido que Canguru 2
        //  ENTAO "NO"
        if(x1 > x2 && v1 > v2) return "NO";
        
        // SE 
        //    Canguru 2 esta a frente de Canguru 1
        //   E
        //    Canguru 2 e mais rapido que Canguru 1
        //  ENTAO "NO"
        if(x2 > x1 && v2 > v1) return "NO";
        
        
        // Equacao da reta Canguru 1:
        //   F¹( t ) = pos1 + vel1 * t)
        
        // Equacao da reta Canguru 2:
        //   F²( t ) = pos2 + vel2 * t)
        
        // pos1 + vel1 * t = pos2 + vel2 * t >= 1 ele intercepta 
        // isolando o "t" t == numero de pulos
        // pos1 - pos2 = ( vel2 - vel1  ) * t
        
        if(v2 == v1) return "NO";
        
        double t = (x1 - x2) / (v2 - v1);
        if ( t >= 0 && (x2 - x1) % (v1 - v2) == 0 ) {
            return "YES";
        } else {
            return "NO";
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Kangaroo.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
