import java.util.*;

public class Solution {
    public void resolve(Problem prob) {
        //ordonam studentii in functie de Scor, si ii le facem match-uing cu prima facultate care ii accepta
        System.out.println();

        prob.getStudentList().sort((Comparator.comparing( Student::getScore )));

        for ( Student s : prob.getStudentList() ) {
                for(School wantedSchool : prob.getStudPrefMap().get(s))
                {
                    if(prob.schoolWantStud(wantedSchool,s))
                    {
                        System.out.println("Studentul " + s.getName() + " a ajuns la: " + wantedSchool.getName());
                        wantedSchool.setCapacity( wantedSchool.getCapacity()-1 );
                        break;
                    }

                }
        }





    }
}
