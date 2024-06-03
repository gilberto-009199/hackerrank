package algoritm;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import static java.lang.System.out;


// https://www.hackerrank.com/challenges/game-of-thrones/problem

public class GameOfThrones {

	 /*
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) {
    	boolean contentPalindromo = true; 
    	
    	Map<Character,Integer> mapLetters = new HashMap<Character, Integer>();
    	
    	for(char letter : s.toCharArray()) {
    		mapLetters.put(letter, mapLetters.getOrDefault(letter, 0) + 1 );
    	}
    	
    	// Para uma string de comprimento par, todos os caracteres devem aparecer um número par de vezes.
    	if(s.length() % 2 == 0) {
    		for(Entry<Character, Integer> letter : mapLetters.entrySet()) {
    			if(letter.getValue() % 2 != 0) contentPalindromo = false; 
        	}
    	}
    	
    	// Para uma string de comprimento ímpar, todos os caracteres,
    	// exceto um, devem aparecer um número par de vezes (o caractere que aparece um número ímpar de vezes será 
    	// o caractere do meio no palíndromo).
    	if(s.length() % 2 != 0) {
    		int countImpar = 0;
    		for(Entry<Character, Integer> letter : mapLetters.entrySet()) {
    			if(letter.getValue() % 2 != 0) countImpar += 1; 
        	}
    		contentPalindromo = (countImpar <= 1 );
    	}
    	
    	return contentPalindromo ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = GameOfThrones.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
