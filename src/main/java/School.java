import com.github.javafaker.Faker;

import java.util.Objects;
import java.util.stream.IntStream;

public class School implements Comparable<School> {
    private String name;
    private int capacity;
    public School(String name) {
        this.name = name;
    }
    public School()
    {
        Faker faker = new Faker();
        name=faker.university().name();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getCapacity( ) {
        return capacity;
    }
    public String getName( ) {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(School otherSchool) {
        return CharSequence.compare(this.getName(), otherSchool.getName());
    }

    @Override
    public String toString( ) {
        return super.toString();
    }
}
