import java.util.Objects;
import java.util.stream.IntStream;

public class School implements Comparable<School> {
    private String name;

    public School(String name) {
        this.name = name;
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
