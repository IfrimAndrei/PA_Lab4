import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public void resolve(Problem prob) {
        //ordonam studentii in functie de Scor, si ii le facem match-uing cu prima facultate care ii accepta
        //cand un student este acceptat la o facultate, scadem capacitatea la acea facultate cu 2
        //si crestem capacitatea la toate celelalte scoli cu 1 (au loc liber acum,iar facultatea aleasa are un loc in minus)
        //fac asta pentru a evita stergea elementelor deoarece ajung la erori cand fac asta in for
        System.out.println();

        prob.getStudentList().sort((Comparator.comparing( Student::getScore )));
        Collections.reverse(prob.getStudentList());
        for ( Student s : prob.getStudentList() ) {
                for(School wantedSchool : prob.getStudPrefMap().get(s))
                {
                    if(prob.schoolWantStud(wantedSchool,s))
                    {
                        System.out.println("Studentul " + s.getName() + " a ajuns la: " + wantedSchool.getName());
                        wantedSchool.setCapacity( wantedSchool.getCapacity() - 2 );
                        List<School> result = prob.getSchoolList().stream()
                                .filter(std -> prob.getSchoolPrefMap().get(std).contains(s))
                                .collect( Collectors.toList());

                        for (School freeSpot : result) {
                            freeSpot.setCapacity( freeSpot.getCapacity() + 1 );
                        }
                        break;
                    }

                }
        }





    }
}
