import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
    Problem example = new Problem();
    example.create();
    example.print();
    Solution sol = new Solution();
    sol.resolve( example );

    }
}
