import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

    Compulsory();
    Optional();

    }

    public static void Compulsory()
    {
        Problem exampleComp = new Problem();
        exampleComp.initMapsCompulsory();
        exampleComp.print();
        System.out.println("\n----------------------------------");

    }
    public static void Optional()
    {
        Problem exampleOpt = new Problem();
        exampleOpt.initMapsOptional();
        exampleOpt.print();
        Solution sol = new Solution();
        sol.resolve( exampleOpt );
    }

}
