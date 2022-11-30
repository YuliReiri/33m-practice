package example.flatmap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javafx.util.Pair;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {


// part I 
         int[][] arr ={{2,3,4}, {11,8,9}, {22,1,5}, {4,5,5}};
        
        Stream<int[]> s = Arrays.stream(arr);

        final IntStream sFlat = s.flatMapToInt( (int[] x) -> Arrays.stream(x) );

        int[] newArray = sFlat.filter( (int p) -> p < 5).toArray(); 

        System.out.println( Arrays.toString(newArray));

        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        String [] newArr = Arrays.stream(array).flatMap(
            x-> Arrays.stream(x)).filter(el-> !el.equals("a")).toArray(String[]::new);        

// part II

        Student s1 = new Student("001", "Aleks", "Groz");
        s1.addBook("Java 8 extended");
        s1.addBook( "Spring boot in action");
        s1.addBook( "Effictive Java");


        Student s2 = new Student( "002", "Shlomi", "Tailer" );

        s2.addBook("Effictive Java");
        s2.addBook("Introduction to HTML" );
      


        Student s3 = new Student( "003", "Petr", "Tailer" );

        s3.addBook("Effictive Java");
        s3.addBook("Introduction to HTML" );
        List<Student> students  = new ArrayList<Student>();
        students.add(s2);
        students.add(s1);
        students.add(s3);
 

        processStudents( students);

        
    }

    static void processStudents( List<Student> students ) {

        Stream<Student> studentStream = students.stream();
        Stream<Set<String>> booksStream  = studentStream.map( (Student s) -> s.getBooks());

        Stream<String > booksNamesStream = booksStream.flatMap( (Set x) -> x.stream() );

        Set < String > books = booksNamesStream.filter( (String sBookName) -> sBookName.contains("Java")).collect(
            Collectors.toSet());

        Map<String, Set< String> >  result = students.stream().collect( Collectors.toMap(
            s1 -> s1.getId(),
            s1 -> s1.getBooks()
        ) );
        Stream< Map.Entry<String, Set<String>> > mapStream = result.entrySet().stream(); 
        
        Stream <Map.Entry<String, Set<String>>> mS1 = mapStream.filter( (x) -> !x.getKey().contains("001"));

        Map<String, Set<String>> rM1 = mS1.collect( Collectors.toMap( 
            w1 -> w1.getKey(),
            w1 -> w1.getValue()
        )); 

        //Using groupingBy method to count number of students with same Second name
        Map<String, Long> sr1 = students.stream().collect(
            Collectors.groupingBy(s -> s.getFamilyName(),Collectors.counting()
        ));
        //How many users red the same book
        Map<String, Long> res2 =  students.stream().map( student ->
        
            {
                List<Pair<String,String>> l = 
                new ArrayList<Pair<String,String>> ();

                student.getBooks().forEach( b -> l.add(
                    new Pair<String, String>( b, student.getId())));
                return l;
          
            }
        
        ).flatMap( c -> c.stream()).collect( 
            Collectors.groupingBy( x -> x.getKey(), Collectors.counting()));

        System.out.println(res2);

        System.out.println(sr1);

   /*      Map<Integer, Object> m = new HashMap<Integer, Object>();
        Set<Map.Entry<Integer, Object>>  k = m.entrySet();
        for ( Map.Entry<Integer, Object> i : k ){
            i.getKey();
            i.getValue();
        }
        Set<Integer> keys = m.keySet();
*/

       // System.out.println( rM1 );
//        System.out.println( result );
        
        //books.forEach( System.out::println );
        //books.forEach( x -> System.out.println(x) );

        //System.out.println( books );
    }
}
