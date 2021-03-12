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
        Set<School> schoolList = new TreeSet<School>( Arrays.asList( schools ) );

        Map <Student,List<School>> studPrefMap = new HashMap<>();
        studPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        studPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        studPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        studPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));

        Map <School,List<Student>> schoolPrefMap = new HashMap<>();
        schoolPrefMap.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        schoolPrefMap.put(schools[0], Arrays.asList(students[0], students[2], students[1]));
        schoolPrefMap.put(schools[0], Arrays.asList(students[0], students[1], students[3]));


    }
}