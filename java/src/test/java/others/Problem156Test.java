package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem156Test {
    @Test
    void solution() throws IOException {
        Problem156 problem156 = new Problem156();
        String p = "2\n" +
                "1 0\n" +
                "3 2\n" +
                "1 2\n" +
                "3 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem156.solution();
    }
}