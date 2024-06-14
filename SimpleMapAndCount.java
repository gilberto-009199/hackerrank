package algoritm;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.stream.Collectors.groupingBy;
import static java.util.Arrays.stream;
import static java.util.function.Function.identity;

// Java 11
// javac SimpleRadixSort.java && java SimpleRadixSort
public class SimpleMapAndCount {
	public static void main(String... args) {
		
        var input = new int[]{  7, 2, 7, 3, 3, 4, 8, 8  };
        // Mount Map
        var map = stream(input)
			        	.boxed()
			        	.collect(groupingBy(identity(), Collectors.counting()));
		
        
        // Filter in Map
        var uniquesNumber = map.entrySet().stream()
                		  				  .filter(entry -> entry.getValue() == 1)
                		                   .map(Map.Entry::getKey);
        
        // Get Max
        var maxAndUnique = uniquesNumber.max(Integer::compareTo).orElse(-1);
        // Result
        out.println(maxAndUnique);
	}
}
