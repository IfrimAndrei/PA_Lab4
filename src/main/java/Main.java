import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main (String[] args){
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);

        List<Student> studentList = new LinkedList<>( Arrays.asList( students ) );
        studentList.sort( (Comparator.comparing( Student::getName )) );

        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i) )
                .toArray(School[]::new);


        TreeSet<School> schoolList = new TreeSet<>();
        for (School s : schools) {
            schoolList.add(s);
        }
        //( Arrays.asList( schools )



        System.out.println(studentList + "\n" + schoolList );
    }
}