package main;

// https://www.hackerrank.com/challenges/sock-merchant/problem

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

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        int countPair = 0;
        int maxNumber = 0;
        for(int i = 0 ; i < ar.size(); i++) {
            if(maxNumber < ar.get(i)) {
                maxNumber = ar.get(i);
            }
        }
        
        var vectRadix = new int[maxNumber+1];
        
        for(int i = 0 ; i < ar.size(); i++) {
            vectRadix[ar.get(i)] += 1;
        }
        
        for(int i = 0 ; i < vectRadix.length; i++) {
            countPair += vectRadix[i] / 2;
        }
        
        return countPair;
    }

}

public class SockMerchant {
	
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
