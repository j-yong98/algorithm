package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem165Test {
    @Test
    void solution() throws IOException {
        Problem165 problem165 = new Problem165();
        String p = "3\n" +
                "5\n" +
                "0 0 0 0 0\n" +
                "0 0 0 1 0\n" +
                "0 0 0 1 0\n" +
                "2 2 1 1 0\n" +
                "0 0 0 0 0\n" +
                "4 0\n" +
                "2 0\n" +
                "6\n" +
                "0 0 0 0 0 0\n" +
                "0 1 1 0 0 0\n" +
                "0 0 0 1 2 0\n" +
                "1 1 0 1 0 1\n" +
                "0 0 0 1 0 1\n" +
                "0 0 0 2 0 1\n" +
                "5 0\n" +
                "2 5\n" +
                "6\n" +
                "0 0 0 0 0 0\n" +
                "0 0 0 0 0 0\n" +
                "1 0 1 1 1 0\n" +
                "1 0 0 0 0 0\n" +
                "1 0 1 1 1 0\n" +
                "0 0 2 0 2 0\n" +
                "5 0\n" +
                "3 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem165.solution();
    }
}