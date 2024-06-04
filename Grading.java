package algoritm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/grading/problem

public class Grading {

	// get prox number multiple (numberMultiple) greatesd number
	public static int multipleGreatedNumber(int number, int numberMultiple) {
		
		int proxMultiple = number + numberMultiple;
		
		if(number % numberMultiple == 0)return proxMultiple;
				
		
		for(int i = number+1; i < number + numberMultiple; i++){
			if(i % numberMultiple == 0)return i;
		}
		
		return proxMultiple;
	}
	/*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
    	List<Integer> result = new ArrayList<Integer>(grades.size());
    	
    	for(int grade : grades) {
    		
    		int nowGrade = grade;

    		int multiple = multipleGreatedNumber(nowGrade, 5);
    		
    		boolean multipleLess40Then = multiple < 40;
    		if(multipleLess40Then) {
    			result.add( max(nowGrade, 100 ));
    			continue;
    		}
    		
    		int diff = multiple - nowGrade;
    		boolean diffLessTreeThen = diff < 3; 
    		if(diffLessTreeThen) {
    			nowGrade = multiple;
    		}
    		
    		result.add( max(nowGrade, 100 ));

    	}
    	
    	
    	return result;
    }
    
    private static Integer max(int number, int max_number) {
		return number > max_number ? max_number : number ;
	}
    
	public static void main(String[] args) throws IOException {
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Grading.gradingStudents(grades);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
    
}
