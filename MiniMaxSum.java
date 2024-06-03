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

public class MiniMaxSum {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void miniMaxSum(List<Integer> arr) {

        long[] vectSum = new long[arr.size()];

        for(int i = 0; i < arr.size(); i++){
          for(int j = 0; j < arr.size(); j++){

            if(i != j)vectSum[i] += arr.get(j);

          }   
        }

        // get min 
        long min = Arrays.stream(vectSum).min().getAsLong();
        // get max
        long max = Arrays.stream(vectSum).max().getAsLong();

        System.out.print( min +" "+ max );
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        MiniMaxSum.miniMaxSum(arr);

        bufferedReader.close();
    }
}
