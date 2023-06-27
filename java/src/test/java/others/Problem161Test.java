package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem161Test {
    @Test
    void solution() throws IOException {
        Problem161 problem161 = new Problem161();
        String p = "2\n" +
                "13 12 8 13\n" +
                "1 2 1 3 2 4 3 5 3 6 4 7 7 12 5 9 5 8 6 11 6 10 11 13\n" +
                "10 9 2 10\n" +
                "1 2 1 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10";

        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem161.solution();
    }
}