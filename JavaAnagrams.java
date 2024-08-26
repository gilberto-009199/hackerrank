package algoritm;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.io.*;

// https://www.hackerrank.com/challenges/java-anagrams/problem?isFullScreen=true
public class JavaAnagrams {
	public static void main(String... args) {
		var reader = new Scanner(System.in);
		var a = reader.next();
		var b = reader.next();
 
		a = a.toLowerCase();
    b = b.toLowerCase();
        
		// Faça um map aonde vc tenha key como seno a letra e value o count
    Map<Character, Long> mapA = a.chars()
    .mapToObj(c -> (char) c)
    .collect(
        Collectors.groupingBy(Function.identity(), Collectors.counting()
    ));

    Map<Character, Long> mapB = b.chars()
    .mapToObj(c -> (char) c)
    .collect(
        Collectors.groupingBy(Function.identity(), Collectors.counting()
    ));
    
    if(mapA.equals(mapB)) {
      System.out.print("Anagrams");
    }else System.out.print("Not Anagrams");
        
        
	}
}
