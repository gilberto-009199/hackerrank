import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-string-reverse/problem?isFullScreen=true
public class Solution {

    public static void main(String[] args) {
        var reader = new Scanner(System.in);
        var word = reader.next();
        var isPalindromo = true;
        // for verify Palindromo
        for(var i = 0; i < word.length() && isPalindromo; i++){
            var letter = word.substring(i,i+1);
            var letterPalindro = word.substring((word.length() - i - 1), (word.length() - i) );
            isPalindromo = letter.equals(letterPalindro);
        }
        reader.close();
        if(isPalindromo)System.out.println("Yes");
        else System.out.println("No");
    }
}
