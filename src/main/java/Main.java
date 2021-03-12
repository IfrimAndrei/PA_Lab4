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
        Map <School,List<Student>> schoolPrefMap = new HashMap<>();
        initMaps(schoolPrefMap,studPrefMap,students,schools);
        ShowPref( schoolPrefMap ,studPrefMap);

    }
    public static void initMaps(Map <School,List<Student>> schoolPrefMap,Map <Student,List<School>> studPrefMap,Student[] students,School[] schools)
    {
        studPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        studPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        studPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        studPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));

        schoolPrefMap.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        schoolPrefMap.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schoolPrefMap.put(schools[2], Arrays.asList(students[0], students[1], students[3]));


    }
    public static String studentsToString(List<Student> students)
    {
        StringBuilder studs= new StringBuilder();
        for( Student i: students)
        {
            //System.out.println(i.getName() );
            studs.append( i.getName() ).append( " " );
        }
        return studs.toString();
    }
    public static String schoolsToString(List<School> schools)
    {
        StringBuilder schoolString= new StringBuilder();
        for( School i: schools)
        {
            schoolString.append( i.getName() ).append( " " );
        }
        return schoolString.toString();
    }
    public static void ShowPref(Map <School,List<Student>> schoolPrefMap,Map <Student,List<School>> studPrefMap)
    {
        System.out.println("Lista de preferinte este: ");
        schoolPrefMap.forEach((key, value) -> System.out.println(key.getName() + ": " + studentsToString( value )));
        System.out.println();
        studPrefMap.forEach((key, value) -> System.out.println(key.getName() + ": " + schoolsToString( value )));
    }


}