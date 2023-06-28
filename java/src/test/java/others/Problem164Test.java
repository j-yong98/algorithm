package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem164Test {
    @Test
    void solution() throws IOException {
        Problem164 problem164 = new Problem164();
        String p = "2\n" +
                "6 5\n" +
                "1 2\n" +
                "2 5\n" +
                "5 1\n" +
                "3 4\n" +
                "4 6\n" +
                "6 8\n" +
                "1 2\n" +
                "2 5\n" +
                "5 1\n" +
                "3 4\n" +
                "4 6\n" +
                "5 4\n" +
                "2 4\n" +
                "2 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem164.solution();
    }
}