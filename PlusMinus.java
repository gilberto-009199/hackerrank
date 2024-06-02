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


// https://www.hackerrank.com/challenges/plus-minus/problem
// em java quando queremos trbalahr com
// numeros abaixo da virgulo
// por padrão e melhor ja armazemarnos os campos da contas em
// double e float
public class PlusMinus {

	/*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    	double countIntegers = 0;
    	double countNegatives = 0;
    	double countZeros = 0;
    	double size = arr.size();
    	
    	countIntegers = arr.stream().filter(value -> value > 0).count();
    	countNegatives = arr.stream().filter(value -> value < 0).count();
    	countZeros = arr.stream().filter(value -> value == 0).count();
    	
    	// decimal(2, 6) =  00.000000 
    	double proportionIntegers	= countIntegers / size;
    	double proportionNegatives	= countNegatives / size;
    	double proportionZeros		= countZeros / size;
     
    	System.out.printf("%.6f\n", proportionIntegers);
        System.out.printf("%.6f\n", proportionNegatives);
        System.out.printf("%.6f\n", proportionZeros);
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        PlusMinus.plusMinus(arr);

        bufferedReader.close();
    }
}

