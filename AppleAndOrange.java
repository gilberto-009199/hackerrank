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

// https://www.hackerrank.com/challenges/apple-and-orange/problem
public class AppleAndOrange {

	public static class Range{
		private int init;
		private int end;
		public Range(int init, int end) {
			this.init = init;
			this.end = end;
		}
		
		public boolean contains(int elm) {
			return elm >= init && elm <= end;
		}
	}
	
	/*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int posMacieira     = a;
        int posLarangeira   = b;
        int countMacas		= 0;
        int countLaranjas	= 0;
        
        Range casa			= new Range(s, t);

        for(int dist : apples) {
        	// Corrige ESQUERDA e Direita
        	int posX  = dist + posMacieira;
        	countMacas += casa.contains(posX) ? 1 : 0;
        }
        
        for(int dist : oranges) {
        	// Corrige ESQUERDA e Direita
        	int posX  = dist + posLarangeira;
        	countLaranjas += casa.contains(posX) ? 1 : 0;
        }
        
        System.out.println(countMacas);
        System.out.println(countLaranjas);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int s = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int a = Integer.parseInt(secondMultipleInput[0]);

        int b = Integer.parseInt(secondMultipleInput[1]);

        String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(thirdMultipleInput[0]);

        int n = Integer.parseInt(thirdMultipleInput[1]);

        List<Integer> apples = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> oranges = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        AppleAndOrange.countApplesAndOranges(s, t, a, b, apples, oranges);

        bufferedReader.close();
    }
}
