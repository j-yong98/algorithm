package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem124Test {
    @Test
    void solution() throws IOException {
        Problem124 problem124 = new Problem124();
        String p = "3\n" +
                "1 3 5 7\n" +
                "0 5 2 4\n" +
                "0 5 1 6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem124.solution();
    }
}