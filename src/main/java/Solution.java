import java.util.*;

public class Solution {
    public void resolve(Problem prob) {
        //Algorithm that resolves "disagreements", a student wants to go to a School, but the School doesnt want the student, or vice versa
        //....

        //Algorithm for creating a matching
        System.out.println();
        int nrMatching = 0;
        int freeStudents = prob.getStudentList().size();

        while (freeStudents != 0)

        {    start:
            for ( Student s : prob.getStudentList() )
            {
                //System.out.print("b");
                List<School> schoolChoices = prob.getStudPrefMap().get( s );
                School topChoice = schoolChoices.get( 0 );
                List<Student> topChoiceStuds = prob.getSchoolPrefMap().get( topChoice );
                for ( int i = 0 ; i < topChoice.getCapacity() ; i++ ) {
                    if ( s == (topChoiceStuds.get( i )) ) {
                        freeStudents--;
                        System.out.println( "Studentul  " + s.getName() + " a intrat la " + topChoice.getName() );
                        topChoiceStuds.remove( i );

                        topChoice.setCapacity( topChoice.getCapacity() - 1 );

                        for ( School otherSchool : prob.getSchoolList() ) {
                            List<Student> auxList = prob.getSchoolPrefMap().get( otherSchool );
                            for ( int j = 0 ; j < auxList.size() ; j++ ) {
                                if ( s == (auxList.get( j )) ) {
                                    List modifiableList = new ArrayList( Collections.singletonList( auxList ) );
                                    modifiableList.remove( j );
                                    break start;
                                }

                            }
                        }

                        System.out.println(prob.getStudentList().remove( s ));
                        break;
                    }

                }

            }
            //System.out.println( "a" );
        }



    }
}
