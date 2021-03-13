import java.util.List;

public class Solution {
    public void resolve(Problem prob)
    {
        //algorithm that resolves "disagreements", a student wants to go to a School, but the School doesnt want the student, or vice versa

        //Take a students
        //Go to studs first options
        //See if they can get on the wanted School on top spots (if they're in the list :0 ; capacity-1)
        //{
        //}
        //Else go to next students

        for(Student s : prob.getStudentList())
        {
            List<School> schoolChoices=prob.getStudPrefMap().get(s);
            School topChoice = schoolChoices.get(0);
            List<Student>topChoiceStuds= prob.getSchoolPrefMap().get(topChoice);
            for(int i=0; i<topChoice.getCapacity() ; i++)
            {
                if(s==(topChoiceStuds.get(i)))
                {
                    System.out.println("Studentul  " + s.getName() + "a intrat la " + topChoice.getName());
                }
                else System.out.println("nu");
            }





        }

    }
}
