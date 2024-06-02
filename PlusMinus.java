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
    	BigDecimal size =  new BigDecimal(arr.size());
    	
    	countIntegers = arr.stream().filter(value -> value > 0).count();
    	countNegatives = arr.stream().filter(value -> value < 0).count();
    	countZeros = arr.stream().filter(value -> value == 0).count();
    	
    	// decimal(2, 6) =  00.000000 
    	// Cálculo das proporções
        BigDecimal proportionIntegers = new BigDecimal(countIntegers).divide(size, 6, RoundingMode.HALF_UP);
        BigDecimal proportionNegatives = new BigDecimal(countNegatives).divide(size, 6, RoundingMode.HALF_UP);
        BigDecimal proportionZeros = new BigDecimal(countZeros).divide(size, 6, RoundingMode.HALF_UP);

        // Formatação e exibição das proporções com 6 casas decimais
        System.out.println(proportionIntegers.setScale(6, RoundingMode.HALF_UP));
        System.out.println(proportionNegatives.setScale(6, RoundingMode.HALF_UP));
        System.out.println(proportionZeros.setScale(6, RoundingMode.HALF_UP));
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

