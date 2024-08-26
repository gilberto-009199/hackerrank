import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-string-tokens/problem?isFullScreen=true
public class JavaStringTokens {
    public static void main(String... args) {
        var reader = new Scanner(System.in);
        if(!reader.hasNext()){
            System.out.println(0);
            return;
        }
        var s = reader.nextLine().trim();
        var lines = s.split("[ !,?\\._'@]+");
        System.out.println(lines.length);
        for(var line : lines){
            System.out.println(line);
        }
        reader.close();
    }
}
