import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem {
    private List<Student> studentList = new LinkedList<Student>();
    private Set<School> schoolList = new TreeSet<School>();
    private Map <Student,List<School>> studPrefMap = new HashMap<>();
    private Map <School,List<Student>> schoolPrefMap = new TreeMap<>();

    public void create (){

        //initMapsCompulsory();
        initMapsOptional();


    }

    public void schoolCandidats(List<School> target) //display the students who find acceptable a given list of schools
    {

        List<Student> result = studentList.stream()
                .filter(std -> studPrefMap.get(std).containsAll(target))
                .collect( Collectors.toList());

        System.out.print("Studenti care vor la acele scoli: " );
        for (Student s : result) {
            System.out.print(s.getName() + " ");
        }
        // return result

    }
    public void studentOptions(List<Student> target) //display schools that have a given student as their top preference
    {
        List<School> result = schoolList.stream()
                .filter(std -> schoolPrefMap.get(std).containsAll(target))
                .collect( Collectors.toList());

        System.out.print("Scoli care vor acei studenti: " );
        for (School s : result) {
            System.out.print(s.getName() + " ");
        }
    }

    public void initMapsCompulsory()//The Problem given as example,with H0 H1...,without adding numbers/specific names to students;
    {
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);

        studentList.addAll( Arrays.asList(students) );
        studentList.sort( (Comparator.comparing( Student::getName )) );

        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i) )
                .toArray(School[]::new);
        schools[0].setCapacity(1);
        schools[1].setCapacity(2);
        schools[2].setCapacity(2);
        schoolList.addAll( Arrays.asList(schools) );

        studPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        studPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        studPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        studPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));

        schoolPrefMap.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        schoolPrefMap.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schoolPrefMap.put(schools[2], Arrays.asList(students[0], students[1], students[3]));


    }
    public void initMapsOptional() //Initialization for the Optional requirements, students/schools have special names, and students have grades;
    {
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student() )
                .toArray(Student[]::new);

        studentList.addAll( Arrays.asList(students) );
        studentList.sort( (Comparator.comparing( Student::getName )) );

        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School() )
                .toArray(School[]::new);
        schoolList.addAll( Arrays.asList(schools) );
        schools[0].setCapacity(1);
        schools[1].setCapacity(2);
        schools[2].setCapacity(2);

        studPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        studPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        studPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        studPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));

        List<Student> aux= Arrays.asList(students[3], students[0], students[1], students[2]);
        aux.sort( (Comparator.comparing( Student::getScore )) );
        Collections.reverse( aux );
        schoolPrefMap.put(schools[0],aux);

        aux= Arrays.asList(students[0], students[2], students[1]);
        aux.sort( (Comparator.comparing( Student::getScore )) );
        Collections.reverse( aux );
        schoolPrefMap.put(schools[1], aux);

        aux=  Arrays.asList(students[0], students[1], students[3]);
        aux.sort( (Comparator.comparing( Student::getScore )) );
        Collections.reverse( aux );
        schoolPrefMap.put(schools[2],aux);


    }
    public String studentsToString(List<Student> students)
    {
        StringBuilder studs= new StringBuilder();
        for( Student i: students)
        {
            //System.out.println(i.getName() );
            studs.append( i.getName() ).append( " " );
            studs.append( i.getScore()).append( "; " );
        }

        return studs.toString();
    }
    public String schoolsToString(List<School> schools)
    {
        StringBuilder schoolString= new StringBuilder();
        for( School i: schools)
        {
            schoolString.append( i.getName() ).append( "; " );
        }
        return schoolString.toString();
    }
    public void print()
    {
        System.out.println("Lista de preferinte este: ");
        schoolPrefMap.forEach((key, value) -> System.out.println(key.getName() + ": " + studentsToString( value )));
        System.out.println();
        studPrefMap.forEach((key, value) -> System.out.println(key.getName() + ": " + schoolsToString( value )));
    }

    public List<Student> getStudentList( ) {
        return studentList;
    }

    public Set<School> getSchoolList( ) {
        return schoolList;
    }

    public Map<Student, List<School>> getStudPrefMap( ) {
        return studPrefMap;
    }

    public Map<School, List<Student>> getSchoolPrefMap( ) {
        return schoolPrefMap;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setSchoolList(Set<School> schoolList) {
        this.schoolList = schoolList;
    }

    public void setStudPrefMap(Map<Student, List<School>> studPrefMap) {
        this.studPrefMap = studPrefMap;
    }

    public void setSchoolPrefMap(Map<School, List<Student>> schoolPrefMap) {
        this.schoolPrefMap = schoolPrefMap;
    }
}
