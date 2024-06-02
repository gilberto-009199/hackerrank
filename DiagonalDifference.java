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

// https://www.hackerrank.com/challenges/diagonal-difference/problem

public class DiagonalDifference {

	/*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        int sumDigonalLeft = 0;
        int sumDigonalRight = 0;

        for(int i = 0; i < arr.size(); i++){
            sumDigonalLeft += arr.get(i).get(i);
        }

        for(int i = arr.size(); i > 0; i--){
            sumDigonalRight += arr.get(arr.size() - i).get( i - 1);
        }
        
        int result = sumDigonalRight - sumDigonalLeft;
        return result > 0 ? result : result * (-1);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DiagonalDifference.diagonalDifference(arr);
        
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

    }
}
