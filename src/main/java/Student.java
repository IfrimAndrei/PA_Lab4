import com.github.javafaker.Faker;

import java.util.stream.IntStream;

public class Student {
    private String name;
    private int score;

    public Student()
    {
        Faker faker = new Faker();
        name=faker.name().fullName();
        score=faker.number().numberBetween( 1,10 );
    }
    public Student(String name) {
        this.name = name;
    }

    public Student(String name,int score)
    {
        this.name=name;
        this.score=score;
    }

    public String getName( ) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore( ) {
        return score;
    }
}
